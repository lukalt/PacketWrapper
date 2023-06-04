package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetBorderWarningDistance extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SET_BORDER_WARNING_DISTANCE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetBorderWarningDistance() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSetBorderWarningDistance(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'warningBlocks'
     *
     * @return 'warningBlocks'
     */
    public int getWarningBlocks() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'warningBlocks'
     *
     * @param value New value for field 'warningBlocks'
     */
    public void setWarningBlocks(int value) {
        this.handle.getIntegers().write(0, value);
    }

}
