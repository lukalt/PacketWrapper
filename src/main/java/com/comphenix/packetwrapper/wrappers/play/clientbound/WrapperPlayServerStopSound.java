package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.SoundCategory;
import com.comphenix.protocol.wrappers.MinecraftKey;

public class WrapperPlayServerStopSound extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.STOP_SOUND;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerStopSound() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerStopSound(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'name'
     *
     * @return 'name'
     */
    @TestExclusion
    public MinecraftKey getName() {
        return this.handle.getMinecraftKeys().read(0);
    }

    /**
     * Sets the value of field 'name'
     *
     * @param value New value for field 'name'
     */
    public void setName(MinecraftKey value) {
        this.handle.getMinecraftKeys().write(0, value);
    }

    /**
     * Retrieves the value of field 'source'
     *
     * @return 'source'
     */
    @TestExclusion
    public SoundCategory getSource() {
        return this.handle.getSoundCategories().read(0);
    }

    /**
     * Sets the value of field 'source'
     *
     * @param value New value for field 'source'
     */
    public void setSource(SoundCategory value) {
        this.handle.getSoundCategories().write(0, value);
    }

}
