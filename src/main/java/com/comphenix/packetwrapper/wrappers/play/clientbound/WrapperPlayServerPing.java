package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Send from server to client. The client should respond with the same ID using {@link com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientPong}.
 * Currently not used on the Notchian server.
 */
public class WrapperPlayServerPing extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.PING;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPing() {
        super(TYPE);
    }

    public WrapperPlayServerPing(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the id of this ping.
     *
     * @return 'id'
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the id of this ping.
     *
     * @param value New value for field 'id'
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
    }

}
