package com.comphenix.packetwrapper.wrappers.data;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.protocol.events.AbstractStructure;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AbstractWrapper;
import com.comphenix.protocol.wrappers.Converters;
import org.bukkit.World;

/**
 * @author Lukas Alt
 * @since 07.02.2024
 */
public class WrappedCommonPlayerSpawnInfo extends AbstractStructure {
    public final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.CommonPlayerSpawnInfo");

    private StructureModifier<Object> modifier;

    /**
     * Construct a new NMS wrapper.
     *
     * @param handle - the NMS handle
     */
    public WrappedCommonPlayerSpawnInfo(Object handle, StructureModifier<Object> modifier) {
        super(handle, modifier);
    }

    public void setHandle(Object handle) {
        this.handle = handle;
        this.modifier = new StructureModifier<>(handle.getClass()).withTarget(handle);
    }



    /**
     * Retrieves the value of field 'dimensionType'
     *
     * @return 'dimensionType'
     * @deprecated Use {@link #getDimensionType()} instead
     */
    @Deprecated
    public InternalStructure getDimensionTypeInternal() {
        return new InternalStructure(this.modifier.read(0));
    }

    /**
     * Sets the value of field 'dimensionType'
     *
     * @param value New value for field 'dimensionType'
     * @deprecated Use {@link #setDimensionType(ResourceKey)} instead
     */
    @Deprecated
    public void setDimensionTypeInternal(InternalStructure value) {
        modifier.write(0, value.getHandle());
    }


    /**
     * Retrieves Sets the type of the dimension. The resource key is composed of a minecraft key indicating the registry
     * and the dimension type within this registry.
     *
     * @return 'dimensionType'
     */
    public ResourceKey getDimensionType() {
        return this.modifier.withType(MinecraftReflection.getResourceKey(), ResourceKey.CONVERTER).read(0);
    }

    /**
     * Sets the type of the dimension. The resource key is composed of a minecraft key indicating the registry
     * and the dimension type within this registry.
     *
     * @param value New value for field 'dimensionType'
     */
    public void setDimensionType(ResourceKey value) {
        this.modifier.withType(MinecraftReflection.getResourceKey(), ResourceKey.CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'dimension'
     *
     * @return 'dimension'
     * @deprecated Use {@link #getDimension()} instead
     */
    @Deprecated
    public InternalStructure getDimensionInternal() {
        return this.handle.getStructures().read(4);
    }

    /**
     * Sets the value of field 'dimension'
     *
     * @param value New value for field 'dimension'
     * @deprecated Use {@link #setDimension(World)} instead
     */
    @Deprecated
    public void setDimensionInternal(InternalStructure value) {
        this.handle.getStructures().write(4, value);
    }

    /**
     * Retrieves the value of field 'dimension'
     *
     * @return 'dimension'
     */
    @TestExclusion
    public World getDimension() {
        return this.getWorldKeys().read(0);
    }

    /**
     * Sets the value of field 'dimension'
     *
     * @param value New value for field 'dimension'
     */
    public void setDimension(World value) {
        this.getWorldKeys().write(0, value);
    }


    public static EquivalentConverter<WrappedCommonPlayerSpawnInfo> getConverter() {
        return Converters.ignoreNull(Converters.handle(WrappedCommonPlayerSpawnInfo::getHandle, WrappedCommonPlayerSpawnInfo::new, WrappedCommonPlayerSpawnInfo.class));
    }

}
