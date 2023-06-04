package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Acknowledges a user-initiated block change. After receiving this packet, the client will display the block state sent by the server instead of the one predicted by the client.
 */
public class WrapperPlayServerBlockChangedAck extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.BLOCK_CHANGED_ACK;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerBlockChangedAck() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerBlockChangedAck(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'sequence'. This is used for properly syncing block changes to the client after interactions.
     *
     * @return 'sequence'
     */
    public int getSequence() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'sequence'. This is used for properly syncing block changes to the client after interactions.
     *
     * @param value New value for field 'sequence'
     */
    public void setSequence(int value) {
        this.handle.getIntegers().write(0, value);
    }

}
