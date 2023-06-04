package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.ProtocolConversion;
import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.Location;
import org.bukkit.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

/**
 * This packet is sent by the server when a player comes into visible range, not when a player joins.
 */
public class WrapperPlayServerNamedEntitySpawn extends AbstractPacket {
    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.NAMED_ENTITY_SPAWN;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerNamedEntitySpawn() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerNamedEntitySpawn(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves entity id of the player
     *
     * @return 'entityId'
     */
    public int getEntityId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the entity id of the player
     *
     * @param value New value for field 'entityId'
     */
    public void setEntityId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the unique id of the player
     *
     * @return 'playerId'
     */
    public UUID getPlayerId() {
        return this.handle.getUUIDs().read(0);
    }

    /**
     * Sets the unique id of the player
     *
     * @param value New value for field 'playerId'
     */
    public void setPlayerId(UUID value) {
        this.handle.getUUIDs().write(0, value);
    }

    /**
     * Retrieves the value of field 'x'
     *
     * @return 'x'
     */
    public double getX() {
        return this.handle.getDoubles().read(0);
    }

    /**
     * Sets the value of field 'x'
     *
     * @param value New value for field 'x'
     */
    public void setX(double value) {
        this.handle.getDoubles().write(0, value);
    }

    /**
     * Retrieves the value of field 'y'
     *
     * @return 'y'
     */
    public double getY() {
        return this.handle.getDoubles().read(1);
    }

    /**
     * Sets the value of field 'y'
     *
     * @param value New value for field 'y'
     */
    public void setY(double value) {
        this.handle.getDoubles().write(1, value);
    }

    /**
     * Retrieves the value of field 'z'
     *
     * @return 'z'
     */
    public double getZ() {
        return this.handle.getDoubles().read(2);
    }

    /**
     * Sets the value of field 'z'
     *
     * @param value New value for field 'z'
     */
    public void setZ(double value) {
        this.handle.getDoubles().write(2, value);
    }

    /**
     * Retrieves the discrete rotation around the y-axis (yaw)
     *
     * @return 'yRot'
     */
    public byte getYRotRaw() {
        return this.handle.getBytes().read(0);
    }

    /**
     * Sets the discrete rotation around the y-axis (yaw)
     *
     * @param value New value for field 'yRot'
     */
    public void setYRotRaw(byte value) {
        this.handle.getBytes().write(0, value);
    }

    /**
     * Retrieves the value of field 'xRot'
     *
     * @return 'xRot'
     */
    public byte getXRotRaw() {
        return this.handle.getBytes().read(1);
    }

    /**
     * Sets the discrete rotation around the x-axis (pitch)
     *
     * @param value New value for field 'xRot'
     */
    public void setXRotRaw(byte value) {
        this.handle.getBytes().write(1, value);
    }

    @UtilityMethod
    public Location getLocation(@Nullable World world) {
        return new Location(world, getX(), getY(), getZ(), ProtocolConversion.angleToDegrees(getYRotRaw()), ProtocolConversion.angleToDegrees(getXRotRaw()));
    }

    @UtilityMethod
    public void setLocation(@Nonnull Location location) {
        setX(location.getX());
        setY(location.getY());
        setZ(location.getZ());
        setYRotRaw(ProtocolConversion.degreesToAngle(location.getYaw()));
        setXRotRaw(ProtocolConversion.degreesToAngle(location.getPitch()));
    }

}
