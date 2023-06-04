package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerAttachEntity extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ATTACH_ENTITY;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerAttachEntity() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerAttachEntity(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'sourceId'
     *
     * @return 'sourceId'
     */
    public int getSourceId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'sourceId'
     *
     * @param value New value for field 'sourceId'
     */
    public void setSourceId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'destId'
     *
     * @return 'destId'
     */
    public int getDestId() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'destId'
     *
     * @param value New value for field 'destId'
     */
    public void setDestId(int value) {
        this.handle.getIntegers().write(1, value);
    }

}
