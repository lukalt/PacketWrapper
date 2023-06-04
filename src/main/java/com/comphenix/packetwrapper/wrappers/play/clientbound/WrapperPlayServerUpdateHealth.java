package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerUpdateHealth extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.UPDATE_HEALTH;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerUpdateHealth() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerUpdateHealth(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'health'
     *
     * @return 'health'
     */
    public float getHealth() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'health'
     *
     * @param value New value for field 'health'
     */
    public void setHealth(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'food'
     *
     * @return 'food'
     */
    public int getFood() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'food'
     *
     * @param value New value for field 'food'
     */
    public void setFood(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'saturation'
     *
     * @return 'saturation'
     */
    public float getSaturation() {
        return this.handle.getFloat().read(1);
    }

    /**
     * Sets the value of field 'saturation'
     *
     * @param value New value for field 'saturation'
     */
    public void setSaturation(float value) {
        this.handle.getFloat().write(1, value);
    }

}
