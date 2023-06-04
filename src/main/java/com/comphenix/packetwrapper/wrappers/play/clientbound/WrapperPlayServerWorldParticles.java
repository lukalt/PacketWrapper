package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedParticle;

public class WrapperPlayServerWorldParticles extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.WORLD_PARTICLES;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerWorldParticles() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerWorldParticles(PacketContainer packet) {
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
     * Retrieves the value of field 'xDist'
     *
     * @return 'xDist'
     */
    public float getXDist() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'xDist'
     *
     * @param value New value for field 'xDist'
     */
    public void setXDist(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'yDist'
     *
     * @return 'yDist'
     */
    public float getYDist() {
        return this.handle.getFloat().read(1);
    }

    /**
     * Sets the value of field 'yDist'
     *
     * @param value New value for field 'yDist'
     */
    public void setYDist(float value) {
        this.handle.getFloat().write(1, value);
    }

    /**
     * Retrieves the value of field 'zDist'
     *
     * @return 'zDist'
     */
    public float getZDist() {
        return this.handle.getFloat().read(2);
    }

    /**
     * Sets the value of field 'zDist'
     *
     * @param value New value for field 'zDist'
     */
    public void setZDist(float value) {
        this.handle.getFloat().write(2, value);
    }

    /**
     * Retrieves the value of field 'maxSpeed'
     *
     * @return 'maxSpeed'
     */
    public float getMaxSpeed() {
        return this.handle.getFloat().read(3);
    }

    /**
     * Sets the value of field 'maxSpeed'
     *
     * @param value New value for field 'maxSpeed'
     */
    public void setMaxSpeed(float value) {
        this.handle.getFloat().write(3, value);
    }

    /**
     * Retrieves the value of field 'count'
     *
     * @return 'count'
     */
    public int getCount() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'count'
     *
     * @param value New value for field 'count'
     */
    public void setCount(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'overrideLimiter'
     *
     * @return 'overrideLimiter'
     */
    public boolean getOverrideLimiter() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'overrideLimiter'
     *
     * @param value New value for field 'overrideLimiter'
     */
    public void setOverrideLimiter(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'particle'
     *
     * @return 'particle'
     */
    public WrappedParticle getParticle() {
        return this.handle.getNewParticles().read(0);
    }

    /**
     * Sets the value of field 'particle'
     *
     * @param value New value for field 'particle'
     */
    public void setParticle(WrappedParticle value) {
        this.handle.getNewParticles().write(0, value);
    }

}
