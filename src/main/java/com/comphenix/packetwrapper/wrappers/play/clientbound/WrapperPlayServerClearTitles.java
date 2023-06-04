package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerClearTitles extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.CLEAR_TITLES;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerClearTitles() {
        super(TYPE);
    }

    public WrapperPlayServerClearTitles(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'resetTimes'
     *
     * @return 'resetTimes'
     */
    public boolean getResetTimes() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'resetTimes'
     *
     * @param value New value for field 'resetTimes'
     */
    public void setResetTimes(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
