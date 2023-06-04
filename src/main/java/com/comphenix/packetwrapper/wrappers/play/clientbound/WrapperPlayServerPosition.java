package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers;

import java.util.Set;

/**
 * Send by server to client to synchronize the player's position.
 */
public class WrapperPlayServerPosition extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.POSITION;
    private static final Class<?> RELATIVE_MOVEMENT_CLASS = MinecraftReflection.getMinecraftClass("world.entity.RelativeMovement");
    private static final EquivalentConverter<RelativeMovement> RELATIVE_MOVEMENT_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(RelativeMovement.class, RELATIVE_MOVEMENT_CLASS);

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPosition() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerPosition(PacketContainer packet) {
        super(packet, TYPE);
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
     * Retrieves the value of field 'yRot'
     *
     * @return 'yRot'
     */
    public float getYRot() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'yRot'
     *
     * @param value New value for field 'yRot'
     */
    public void setYRot(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'xRot'
     *
     * @return 'xRot'
     */
    public float getXRot() {
        return this.handle.getFloat().read(1);
    }

    /**
     * Sets the value of field 'xRot'
     *
     * @param value New value for field 'xRot'
     */
    public void setXRot(float value) {
        this.handle.getFloat().write(1, value);
    }

    /**
     * Retrieves the value of field 'relativeArguments'
     *
     * @return 'relativeArguments'
     */
    public Set<RelativeMovement> getRelativeArguments() {
        return this.handle.getSets(RELATIVE_MOVEMENT_CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'relativeArguments'
     *
     * @param value New value for field 'relativeArguments'
     */
    public void setRelativeArguments(Set<RelativeMovement> value) {
        this.handle.getSets(RELATIVE_MOVEMENT_CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'id'
     *
     * @return 'id'
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'id'
     *
     * @param value New value for field 'id'
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    public enum RelativeMovement {
        X,
        Y,
        Z,
        Y_ROT,
        X_ROT
    }

}
