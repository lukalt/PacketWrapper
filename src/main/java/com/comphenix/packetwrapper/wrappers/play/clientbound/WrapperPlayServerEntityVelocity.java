package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerEntityVelocity extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_VELOCITY;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerEntityVelocity() {
        super(TYPE);
    }

    public WrapperPlayServerEntityVelocity(PacketContainer packet) {
        super(packet, TYPE);
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

    /**
     * Retrieves the value of field 'xa'
     *
     * @return 'xa'
     */
    public int getXa() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'xa'
     *
     * @param value New value for field 'xa'
     */
    public void setXa(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'ya'
     *
     * @return 'ya'
     */
    public int getYa() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'ya'
     *
     * @param value New value for field 'ya'
     */
    public void setYa(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'za'
     *
     * @return 'za'
     */
    public int getZa() {
        return this.handle.getIntegers().read(3);
    }

    /**
     * Sets the value of field 'za'
     *
     * @param value New value for field 'za'
     */
    public void setZa(int value) {
        this.handle.getIntegers().write(3, value);
    }

}
