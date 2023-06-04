package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.MinecraftKey;

import java.util.Set;

public class WrapperPlayServerUpdateEnabledFeatures extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.UPDATE_ENABLED_FEATURES;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerUpdateEnabledFeatures() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerUpdateEnabledFeatures(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'features'
     *
     * @return 'features'
     */
    public Set<MinecraftKey> getFeatures() {
        return this.handle.getSets(MinecraftKey.getConverter()).read(0);
    }

    /**
     * Sets the value of field 'features'
     *
     * @param value New value for field 'features'
     */
    public void setFeatures(Set<MinecraftKey> value) {
        this.handle.getSets(MinecraftKey.getConverter()).write(0, value);
    }

}
