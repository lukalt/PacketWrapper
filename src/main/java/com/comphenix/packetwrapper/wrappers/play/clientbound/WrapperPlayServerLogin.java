package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.ResourceKey;
import com.comphenix.packetwrapper.wrappers.data.Vector3I;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import org.bukkit.World;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Set;

public class WrapperPlayServerLogin extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.LOGIN;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerLogin() {
        super(TYPE);
    }

    public WrapperPlayServerLogin(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'playerId'
     *
     * @return 'playerId'
     */
    public int getPlayerId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'playerId'
     *
     * @param value New value for field 'playerId'
     */
    public void setPlayerId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'hardcore'
     *
     * @return 'hardcore'
     */
    public boolean getHardcore() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'hardcore'
     *
     * @param value New value for field 'hardcore'
     */
    public void setHardcore(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'gameType'
     *
     * @return 'gameType'
     */
    public NativeGameMode getGameType() {
        return this.handle.getGameModes().read(0);
    }

    /**
     * Sets the value of field 'gameType'
     *
     * @param value New value for field 'gameType'
     */
    public void setGameType(NativeGameMode value) {
        this.handle.getGameModes().write(0, value);
    }

    /**
     * Retrieves the value of field 'previousGameType'
     *
     * @return 'previousGameType'
     */
    public NativeGameMode getPreviousGameType() {
        return this.handle.getGameModes().read(1);
    }

    /**
     * Sets the value of field 'previousGameType'
     *
     * @param value New value for field 'previousGameType'
     */
    public void setPreviousGameType(NativeGameMode value) {
        this.handle.getGameModes().write(1, value);
    }

    /**
     * Retrieves the value of field 'levels'
     *
     * @return 'levels'
     */
    public Set<World> getLevels() {
        return this.handle.getSets(BukkitConverters.getWorldConverter()).read(0);
    }

    /**
     * Sets the value of field 'levels'
     *
     * @param value New value for field 'levels'
     */
    public void setLevels(Set<World> value) {
        this.handle.getSets(BukkitConverters.getWorldConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'registryHolder'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'registryHolder'
     */
    public InternalStructure getRegistryHolderInternal() {
        return this.handle.getStructures().read(2); // TODO: No specific modifier has been found for type interface net.minecraft.core.RegistryAccess$Frozen Generic type: interface net.minecraft.core.RegistryAccess$Frozen
    }

    /**
     * Sets the value of field 'registryHolder'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'registryHolder'
     */
    public void setRegistryHolderInternal(InternalStructure value) {
        this.handle.getStructures().write(2, value); // TODO: No specific modifier has been found for type interface net.minecraft.core.RegistryAccess$Frozen Generic type: interface net.minecraft.core.RegistryAccess$Frozen
    }

    /**
     * Retrieves the value of field 'dimensionType'
     *
     * @return 'dimensionType'
     * @deprecated Use {@link #getDimensionType()} instead
     */
    @Deprecated
    public InternalStructure getDimensionTypeInternal() {
        return this.handle.getStructures().read(3);
    }

    /**
     * Sets the value of field 'dimensionType'
     *
     * @param value New value for field 'dimensionType'
     * @deprecated Use {@link #setDimensionType(ResourceKey)} instead
     */
    @Deprecated
    public void setDimensionTypeInternal(InternalStructure value) {
        this.handle.getStructures().write(3, value);
    }


    /**
     * Retrieves Sets the type of the dimension. The resource key is composed of a minecraft key indicating the registry
     * and the dimension type within this registry.
     *
     * @return 'dimensionType'
     */
    public ResourceKey getDimensionType() {
        return this.handle.getModifier().withType(MinecraftReflection.getResourceKey(), ResourceKey.CONVERTER).read(1);
    }

    /**
     * Sets the type of the dimension. The resource key is composed of a minecraft key indicating the registry
     * and the dimension type within this registry.
     *
     * @param value New value for field 'dimensionType'
     */
    public void setDimensionType(ResourceKey value) {
        this.handle.getModifier().withType(MinecraftReflection.getResourceKey(), ResourceKey.CONVERTER).write(1, value);
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
     * Retrieves the value of field 'maxPlayers'
     *
     * @return 'maxPlayers'
     */
    public int getMaxPlayers() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'maxPlayers'
     *
     * @param value New value for field 'maxPlayers'
     */
    public void setMaxPlayers(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'chunkRadius'
     *
     * @return 'chunkRadius'
     */
    public int getChunkRadius() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'chunkRadius'
     *
     * @param value New value for field 'chunkRadius'
     */
    public void setChunkRadius(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'simulationDistance'
     *
     * @return 'simulationDistance'
     */
    public int getSimulationDistance() {
        return this.handle.getIntegers().read(3);
    }

    /**
     * Sets the value of field 'simulationDistance'
     *
     * @param value New value for field 'simulationDistance'
     */
    public void setSimulationDistance(int value) {
        this.handle.getIntegers().write(3, value);
    }

    /**
     * Retrieves the value of field 'reducedDebugInfo'
     *
     * @return 'reducedDebugInfo'
     */
    public boolean getReducedDebugInfo() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Sets the value of field 'reducedDebugInfo'
     *
     * @param value New value for field 'reducedDebugInfo'
     */
    public void setReducedDebugInfo(boolean value) {
        this.handle.getBooleans().write(1, value);
    }

    /**
     * Retrieves the value of field 'showDeathScreen'
     *
     * @return 'showDeathScreen'
     */
    public boolean getShowDeathScreen() {
        return this.handle.getBooleans().read(2);
    }

    /**
     * Sets the value of field 'showDeathScreen'
     *
     * @param value New value for field 'showDeathScreen'
     */
    public void setShowDeathScreen(boolean value) {
        this.handle.getBooleans().write(2, value);
    }

    /**
     * Retrieves the value of field 'isDebug'
     *
     * @return 'isDebug'
     */
    public boolean getIsDebug() {
        return this.handle.getBooleans().read(3);
    }

    /**
     * Sets the value of field 'isDebug'
     *
     * @param value New value for field 'isDebug'
     */
    public void setIsDebug(boolean value) {
        this.handle.getBooleans().write(3, value);
    }

    /**
     * Retrieves the value of field 'isFlat'
     *
     * @return 'isFlat'
     */
    public boolean getIsFlat() {
        return this.handle.getBooleans().read(4);
    }

    /**
     * Sets the value of field 'isFlat'
     *
     * @param value New value for field 'isFlat'
     */
    public void setIsFlat(boolean value) {
        this.handle.getBooleans().write(4, value);
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
        return this.getHandle().getIntegers().read(1);
    }

    /**
     * Sets the portal cooldown
     * @since 1.20
     * @param value the number of ticks until the player can use the portal again
     */
    public void setPortalCooldown(int value) {
        this.getHandle().getIntegers().write(1, value);
    }


}
