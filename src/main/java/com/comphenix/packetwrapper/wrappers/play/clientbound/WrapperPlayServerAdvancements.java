package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.MinecraftKey;

import java.util.Map;
import java.util.Set;

public class WrapperPlayServerAdvancements extends AbstractPacket {
    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ADVANCEMENTS;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerAdvancements() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerAdvancements(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'reset'
     *
     * @return 'reset'
     */
    public boolean getReset() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'reset'
     *
     * @param value New value for field 'reset'
     */
    public void setReset(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'added'
     *
     * @return 'added'
     */
    public Map<MinecraftKey, InternalStructure> getAddedInternal() {
        return this.handle.getMaps(MinecraftKey.getConverter(), InternalStructure.getConverter()).read(0);  // TODO
    }

    /**
     * Sets the value of field 'added'
     *
     * @param value New value for field 'added'
     */
    public void setAddedInternal(Map<MinecraftKey, InternalStructure> value) {
        this.handle.getMaps(MinecraftKey.getConverter(), InternalStructure.getConverter()).write(0, value); // TODO
    }

    /**
     * Retrieves the value of field 'removed'
     *
     * @return 'removed'
     */
    public Set<MinecraftKey> getRemoved() {
        return this.handle.getSets(MinecraftKey.getConverter()).read(0);
    }

    /**
     * Sets the value of field 'removed'
     *
     * @param value New value for field 'removed'
     */
    public void setRemoved(Set<MinecraftKey> value) {
        this.handle.getSets(MinecraftKey.getConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'progress'
     *
     * @return 'progress'
     */
    public Map<MinecraftKey, InternalStructure> getProgressInternal() {
        return this.handle.getMaps(MinecraftKey.getConverter(), InternalStructure.getConverter()).read(1); // TODO
    }

    /**
     * Sets the value of field 'progress'
     *
     * @param value New value for field 'progress'
     */
    public void setProgressInternal(Map<MinecraftKey, InternalStructure> value) {
        this.handle.getMaps(MinecraftKey.getConverter(), InternalStructure.getConverter()).write(1, value); // TODO
    }

}
