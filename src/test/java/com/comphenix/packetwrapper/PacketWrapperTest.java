package com.comphenix.packetwrapper;

import com.comphenix.packetwrapper.util.PacketWrapperUtils;
import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.util.Utils;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.ExactReflection;
import com.comphenix.protocol.utility.MinecraftVersion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 07.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class PacketWrapperTest {

    @Test
    void testCurrentVersion() {
        assertEquals(MinecraftVersion.TRAILS_AND_TAILS, MinecraftVersion.getCurrentVersion());
    }

    @Test
    public void testConstructors() throws Exception {

        for (Class<?> aClass : PacketWrapperUtils.getPacketWrappers()) {
            try {
                AbstractPacket packet = (AbstractPacket) aClass.getConstructor().newInstance();
                PacketContainer container = packet.getHandle();
                AbstractPacket other = (AbstractPacket) aClass.getConstructor(PacketContainer.class).newInstance(container);
                assertTrue(new ReflectionEquals(packet).matches(other), "Mismatch for " + aClass + " " + packet + " <-> " + other);
            } catch (Throwable t) {
                throw new RuntimeException("Failed to initialize: " + aClass.getName(), t);
            }
        }

    }

    @Test
    public void testMissingWrappers() throws Exception {
        Set<PacketType> knownTypes = new HashSet<>();

        for (Class<?> aClass : PacketWrapperUtils.getPacketWrappers()) {
            AbstractPacket packet = (AbstractPacket) aClass.getConstructor().newInstance();
            knownTypes.add(packet.getHandle().getType());
        }

        for (PacketType value : PacketType.values()) {
            if (!value.isSupported() || value == PacketType.Play.Client.BLOCK_PLACE) {
                return;
            }
            assertTrue(knownTypes.contains(value), "Missing wrapper for PacketType: " + value);
        }
    }

    @Test
    public void testGetterSetter() throws Exception {
        for (Class<?> aClass : PacketWrapperUtils.getPacketWrappers()) {
            AbstractPacket packet = (AbstractPacket) aClass.getConstructor().newInstance();
            testGetterSetter(packet, false);
        }
    }

    static void testGetterSetter(AbstractPacket packet, boolean filledPacket) {
        try {
            Class<? extends AbstractPacket> explicitClass = packet.getClass();
            List<Method> getters = Arrays.stream(explicitClass.getDeclaredMethods()).filter(value -> {
                return value.getParameterTypes().length == 0
                        && value.getName().startsWith("get")
                        && !value.isAnnotationPresent(UtilityMethod.class)
                        && (filledPacket || value.getReturnType() != InternalStructure.class); // InternalStructures do not work for null values
            }).toList();
            for (Method getter : getters) {
                if (getter.isAnnotationPresent(TestExclusion.class) || getter.isAnnotationPresent(Deprecated.class)) {
                    continue;
                }
                Object value;
                try {
                    value = getter.invoke(packet);
                } catch (NullPointerException ignored) {
                    continue;
                } catch (Throwable t) {
                    throw new RuntimeException("Failed to invoke getter " + getter.getName(), t);
                }

                Method setter;
                try {
                    Class<?> returnType = getter.getReturnType();
                    if (value instanceof Optional) {
                        value = ((Optional<?>) value).orElse(null);
                        if (getter.getGenericReturnType() instanceof ParameterizedType) {
                            returnType = (Class) ((ParameterizedType) getter.getGenericReturnType()).getActualTypeArguments()[0];
                        }
                    }
                    setter = ExactReflection.fromClass(explicitClass, false).findMethod("set" + getter.getName().substring("get".length()), returnType);
                } catch (Throwable t) {
                    throw new RuntimeException("Failed to find setter for " + getter.getName(), t);
                }
                assertNotNull(setter, "No matching setter found for " + getter.getName());
                try {
                    setter.invoke(packet, value);
                    Object returned = getter.invoke(packet);
                    if (returned instanceof Optional) {
                        returned = ((Optional) returned).orElse(null);
                    }
                    if (setter.isAnnotationPresent(TestExclusion.class)) {
                        continue;
                    }
                    assertTrue(new ReflectionEquals(value).matches(returned), "Failed setter/getter write-read-back for " + setter.getName() + ", " + getter.getName() + " " + Utils.tryToString(value) + " <-> " + Utils.tryToString(returned));
                } catch (Throwable t) {
                    t.printStackTrace();
                    throw new RuntimeException("Failed to invoke setter " + setter.getName() + " with value " + value, t);
                }
            }

        } catch (Throwable t) {
            throw
                    new RuntimeException("Getter/Setter test failed for " + packet.getHandle().getHandle().getClass() + " -> " + packet.getHandle().getType(), t);
        }
    }

}