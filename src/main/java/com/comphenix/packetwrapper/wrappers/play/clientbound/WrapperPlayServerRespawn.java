package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.ResourceKey;
import com.comphenix.packetwrapper.wrappers.data.Vector3I;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import org.bukkit.World;

import javax.annotation.Nullable;
import java.util.Optional;

public class WrapperPlayServerRespawn extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.RESPAWN;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRespawn() {
        super(TYPE);
    }

    public WrapperPlayServerRespawn(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'dimensionType'
     *
     * @return 'dimensionType'
     */
    @Deprecated
    public InternalStructure getDimensionTypeInternal() {
        return this.handle.getStructures().read(0);
    }

    /**
     * Sets the value of field 'dimensionType'
     *
     * @param value New value for field 'dimensionType'
     */
    @Deprecated
    public void setDimensionTypeInternal(InternalStructure value) {
        this.handle.getStructures().write(0, value);
    }

    /**
     * Retrieves Sets the type of the dimension. The resource key is composed of a minecraft key indicating the registry
     * and the dimension type within this registry.
     *
     * @return 'dimensionType'
     */
    public ResourceKey getDimensionType() {
        return this.handle.getModifier().withType(MinecraftReflection.getResourceKey(), ResourceKey.CONVERTER).read(0);
    }

    /**
     * Sets the type of the dimension. The resource key is composed of a minecraft key indicating the registry
     * and the dimension type within this registry.
     *
     * @param value New value for field 'dimensionType'
     */
    public void setDimensionType(ResourceKey value) {
        this.handle.getModifier().withType(MinecraftReflection.getResourceKey(), ResourceKey.CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'dimension'
     *
     * @return 'dimension'
     */
    @Deprecated
    public InternalStructure getDimensionInternal() {
        return this.handle.getStructures().read(1);
    }

    /**
     * Sets the value of field 'dimension'
     *
     * @param value New value for field 'dimension'
     */
    @Deprecated
    public void setDimensionInternal(InternalStructure value) {
        this.handle.getStructures().write(1, value);
    }

    /**
     * Retrieves the value of field 'dimension'
     *
     * @return 'dimension'
     */
    @TestExclusion
    public World getDimension() {
        return this.handle.getWorldKeys().read(0);
    }

    /**
     * Sets the value of field 'dimension'
     *
     * @param value New value for field 'dimension'
     */
    public void setDimension(World value) {
        this.handle.getWorldKeys().write(0, value);
    }

    /**
     * Retrieves the value of field 'seed'
     *
     * @return 'seed'
     */
    public long getSeed() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the value of field 'seed'
     *
     * @param value New value for field 'seed'
     */
    public void setSeed(long value) {
        this.handle.getLongs().write(0, value);
    }

    /**
     * Retrieves the value of field 'playerGameType'
     *
     * @return 'playerGameType'
     */
    public NativeGameMode getPlayerGameType() {
        return this.handle.getGameModes().read(0);
    }

    /**
     * Sets the value of field 'playerGameType'
     *
     * @param value New value for field 'playerGameType'
     */
    public void setPlayerGameType(NativeGameMode value) {
        this.handle.getGameModes().write(0, value);
    }

    /**
     * Retrieves the value of field 'previousPlayerGameType'
     *
     * @return 'previousPlayerGameType'
     */
    public NativeGameMode getPreviousPlayerGameType() {
        return this.handle.getGameModes().read(1);
    }

    /**
     * Sets the value of field 'previousPlayerGameType'
     *
     * @param value New value for field 'previousPlayerGameType'
     */
    public void setPreviousPlayerGameType(NativeGameMode value) {
        this.handle.getGameModes().write(1, value);
    }

    /**
     * Retrieves the value of field 'isDebug'
     *
     * @return 'isDebug'
     */
    public boolean getIsDebug() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'isDebug'
     *
     * @param value New value for field 'isDebug'
     */
    public void setIsDebug(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'isFlat'
     *
     * @return 'isFlat'
     */
    public boolean getIsFlat() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Sets the value of field 'isFlat'
     *
     * @param value New value for field 'isFlat'
     */
    public void setIsFlat(boolean value) {
        this.handle.getBooleans().write(1, value);
    }

    /**
     * Retrieves the value of field 'dataToKeep'
     *
     * @return 'dataToKeep'
     */
    public byte getDataToKeep() {
        return this.handle.getBytes().read(0);
    }

    /**
     * Sets the value of field 'dataToKeep'
     *
     * @param value New value for field 'dataToKeep'
     */
    public void setDataToKeep(byte value) {
        this.handle.getBytes().write(0, value);
    }

    /**
     * Retrieves the value of field 'lastDeathLocation'
     *
     * @return 'lastDeathLocation'
     */
    public Optional<Vector3I> getLastDeathLocation() {
        return this.handle.getOptionals(Vector3I.getConverter()).read(0);
    }

    /**
     * Sets the value of field 'lastDeathLocation'
     *
     * @param value New value for field 'lastDeathLocation'
     */
    public void setLastDeathLocation(@Nullable Vector3I value) {
        this.handle.getOptionals(Vector3I.getConverter()).write(0, Optional.ofNullable(value));
    }

    /**
     * Gets the portal cooldown
     * @since 1.20
     * @return the number of ticks until the player can use the portal again
     */
    public int getPortalCooldown() {
        return this.getHandle().getIntegers().read(0);
    }

    /**
     * Sets the portal cooldown
     * @since 1.20
     * @param value the number of ticks until the player can use the portal again
     */
    public void setPortalCooldown(int value) {
        this.getHandle().getIntegers().write(0, value);
    }

}
