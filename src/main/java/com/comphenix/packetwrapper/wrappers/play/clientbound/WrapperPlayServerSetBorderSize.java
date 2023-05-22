package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetBorderSize extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.SET_BORDER_SIZE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetBorderSize() {
        super(TYPE);
    }

    public WrapperPlayServerSetBorderSize(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'size'
     *
     * @return 'size'
     */
    public double getSize() {
        return this.handle.getDoubles().read(0);
    }

    /**
     * Sets the value of field 'size'
     *
     * @param value New value for field 'size'
     */
    public void setSize(double value) {
        this.handle.getDoubles().write(0, value);
    }

}
