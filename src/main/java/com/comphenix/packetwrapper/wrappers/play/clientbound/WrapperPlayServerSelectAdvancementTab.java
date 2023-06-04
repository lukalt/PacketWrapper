package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.MinecraftKey;

public class WrapperPlayServerSelectAdvancementTab extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SELECT_ADVANCEMENT_TAB;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSelectAdvancementTab() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSelectAdvancementTab(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'tab'
     *
     * @return 'tab'
     */
    @TestExclusion
    public MinecraftKey getTab() {
        return this.handle.getMinecraftKeys().read(0);
    }

    /**
     * Sets the value of field 'tab'
     *
     * @param value New value for field 'tab'
     */
    @TestExclusion
    public void setTab(MinecraftKey value) {
        this.handle.getMinecraftKeys().write(0, value);
    }

}
