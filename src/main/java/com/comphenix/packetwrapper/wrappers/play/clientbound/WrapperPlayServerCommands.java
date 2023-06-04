package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;

import java.util.List;

public class WrapperPlayServerCommands extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.COMMANDS;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerCommands() {
        super(TYPE);
    }

    public WrapperPlayServerCommands(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'rootIndex'
     *
     * @return 'rootIndex'
     */
    public int getRootIndex() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'rootIndex'
     *
     * @param value New value for field 'rootIndex'
     */
    public void setRootIndex(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'entries'
     *
     * @return 'entries'
     */
    public List<InternalStructure> getEntriesInternal() {
        return this.handle.getLists(InternalStructure.getConverter()).read(0); // TODO: Multiple modifier have been found for type interface java.util.List Generic type: [class net.minecraft.network.protocol.game.ClientboundCommandsPacket$Entry]
    }

    /**
     * Sets the value of field 'entries'
     *
     * @param value New value for field 'entries'
     */
    public void setEntriesInternal(List<InternalStructure> value) {
        this.handle.getLists(InternalStructure.getConverter()).write(0, value); // TODO
    }

}
