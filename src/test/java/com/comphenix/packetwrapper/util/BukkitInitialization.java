package com.comphenix.packetwrapper.util;

import com.comphenix.protocol.reflect.ExactReflection;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.FieldAccessor;
import com.comphenix.protocol.utility.Util;
import net.minecraft.server.level.WorldServer;
import org.apache.logging.log4j.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R1.inventory.CraftItemFactory;
import org.bukkit.craftbukkit.v1_20_R1.util.Versioning;
import org.spigotmc.SpigotWorldConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Used to ensure that ProtocolLib and Bukkit is prepared to be tested.
 *
 * @author Kristian
 */
public class BukkitInitialization {

    private static final BukkitInitialization instance = new BukkitInitialization();
    private boolean initialized;
    private boolean packaged;

    private BukkitInitialization() {
        LogManager.getLogger().info("Created new BukkitInitialization on " + Thread.currentThread().getName());
    }

    /**
     * Statically initializes the mock server for unit testing
     */
    public static void initializeAll() throws Throwable {
		instance.initialize();
	}

    private static final Object initLock = new Object();

    /**
     * Initialize Bukkit and ProtocolLib such that we can perform unit testing
     */
    private void initialize() throws InvocationTargetException, IllegalAccessException {
        if (initialized) {
            return;
        }

        synchronized (initLock) {
            if (initialized) {
                return;
            }

            try {
                LogManager.getLogger();
            } catch (Throwable ex) {
                // Happens only on my Jenkins, but if it errors here it works when it matters
                ex.printStackTrace();
            }

            instance.setPackage();

            boolean mojangMapped = Util.classExists("net.minecraft.world.level.block.entity.BlockEntity");

            Class<?> sharedConstantsClass = getClass("net.minecraft.SharedConstants");
            ExactReflection.fromClass(sharedConstantsClass, false).getMethod(mojangMapped ? "tryDetectVersion" : "a").invoke(null);
            Class<?> dispenserRegistryClass = getClass("net.minecraft.server.DispenserRegistry", "net.minecraft.server.Bootstrap");
            ExactReflection.fromClass(dispenserRegistryClass, false).getMethod(mojangMapped ? "bootStrap" : "a").invoke(null);

            getClass("net.minecraft.core.IRegistry", "net.minecraft.core.Registry").getName();


            String releaseTarget = MinecraftReflectionTestUtil.RELEASE_TARGET;
            String serverVersion = CraftServer.class.getPackage().getImplementationVersion();
            // Mock the server object
            Server mockedServer = mock(Server.class);

            when(mockedServer.getLogger()).thenReturn(java.util.logging.Logger.getLogger("Minecraft"));
            when(mockedServer.getName()).thenReturn("Mock Server");
            when(mockedServer.getVersion()).thenReturn(serverVersion + " (MC: " + releaseTarget + ")");
            when(mockedServer.getBukkitVersion()).thenReturn(Versioning.getBukkitVersion());
            when(mockedServer.getItemFactory()).thenReturn(CraftItemFactory.instance());
            when(mockedServer.isPrimaryThread()).thenReturn(true);

            Class<?> worldServerClass = getClass("net.minecraft.server.level.WorldServer", "net.minecraft.server.level.ServerLevel");
            Object nmsWorld = mock(worldServerClass);

            SpigotWorldConfig mockWorldConfig = mock(SpigotWorldConfig.class);

            try {
                FieldAccessor spigotConfig = Accessors.getFieldAccessor(nmsWorld.getClass().getField("spigotConfig"));
                spigotConfig.set(nmsWorld, mockWorldConfig);
            } catch (ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }

            CraftWorld world = mock(CraftWorld.class);
            when(world.getHandle()).thenReturn((WorldServer) nmsWorld); // TODO: try to replace this with reflections

            List<World> worlds = Collections.singletonList(world);
            when(mockedServer.getWorlds()).thenReturn(worlds);

            // Inject this fake server
            Bukkit.setServer(mockedServer);
            initialized = true;
        }
    }

    /**
     * Ensure that package names are correctly set up.
     */
    private void setPackage() {
        if (!this.packaged) {
            this.packaged = true;

            try {
                LogManager.getLogger();
            } catch (Throwable ex) {
                // Happens only on my Jenkins, but if it errors here it works when it matters
                ex.printStackTrace();
            }

            MinecraftReflectionTestUtil.init();
        }
    }

    private static Class<?> getClass(String... classNames) {
        for (String className : classNames) {
            try {
                return Class.forName(className);
            } catch (Throwable ignored) {
            }
        }
        throw new IllegalArgumentException("No classes matching " + Arrays.toString(classNames) + " have been found.");
    }
}
