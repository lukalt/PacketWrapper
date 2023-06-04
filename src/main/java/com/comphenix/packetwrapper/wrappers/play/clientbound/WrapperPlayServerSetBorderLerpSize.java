package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetBorderLerpSize extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SET_BORDER_LERP_SIZE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetBorderLerpSize() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSetBorderLerpSize(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'oldSize'
     *
     * @return 'oldSize'
     */
    public double getOldSize() {
        return this.handle.getDoubles().read(0);
    }

    /**
     * Sets the value of field 'oldSize'
     *
     * @param value New value for field 'oldSize'
     */
    public void setOldSize(double value) {
        this.handle.getDoubles().write(0, value);
    }

    /**
     * Retrieves the value of field 'newSize'
     *
     * @return 'newSize'
     */
    public double getNewSize() {
        return this.handle.getDoubles().read(1);
    }

    /**
     * Sets the value of field 'newSize'
     *
     * @param value New value for field 'newSize'
     */
    public void setNewSize(double value) {
        this.handle.getDoubles().write(1, value);
    }

    /**
     * Retrieves the value of field 'lerpTime'
     *
     * @return 'lerpTime'
     */
    public long getLerpTime() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the value of field 'lerpTime'
     *
     * @param value New value for field 'lerpTime'
     */
    public void setLerpTime(long value) {
        this.handle.getLongs().write(0, value);
    }

}
