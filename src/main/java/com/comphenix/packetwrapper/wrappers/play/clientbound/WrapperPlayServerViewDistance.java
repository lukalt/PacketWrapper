package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerViewDistance extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.VIEW_DISTANCE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerViewDistance() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerViewDistance(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'radius'
     *
     * @return 'radius'
     */
    public int getRadius() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'radius'
     *
     * @param value New value for field 'radius'
     */
    public void setRadius(int value) {
        this.handle.getIntegers().write(0, value);
    }

}
