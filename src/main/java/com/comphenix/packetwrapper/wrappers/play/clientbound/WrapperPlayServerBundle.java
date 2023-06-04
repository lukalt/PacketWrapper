package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * A collection of several packets that are sent to the client at once. The client executes each of these packets
 * in the same tick.
 */
public class WrapperPlayServerBundle extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.BUNDLE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerBundle() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerBundle(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets an iterable of the packets in this bundle
     *
     * @return packets in this bundle
     */
    public Iterable<PacketContainer> getPackets() {
        return this.handle.getPacketBundles().read(0);
    }

    /**
     * Sets the packets in this bundle
     *
     * @param packets packets in this bundle
     */
    public void setPackets(Iterable<PacketContainer> packets) {
        this.handle.getPacketBundles().write(0, packets);
    }


}
