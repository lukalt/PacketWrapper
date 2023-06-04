package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.Converters;
import com.comphenix.protocol.wrappers.EnumWrappers;

import java.util.List;

public class WrapperPlayServerCustomChatCompletions extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.CUSTOM_CHAT_COMPLETIONS;
    private static final Class<?> ACTION_TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundCustomChatCompletionsPacket$Action");

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerCustomChatCompletions() {
        super(TYPE);
    }

    public WrapperPlayServerCustomChatCompletions(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'action'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'action'
     * @link getAction
     */
    @Deprecated
    public InternalStructure getActionInternal() {
        return this.handle.getStructures().read(0);
    }

    /**
     * Sets the value of field 'action'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'action'
     * @link setAction
     */
    @Deprecated
    public void setActionInternal(InternalStructure value) {
        this.handle.getStructures().write(0, value);
    }

    /**
     * Retrieves the value of field 'action'
     *
     * @return 'action'
     */
    public Action getAction() {
        return this.handle.getModifier().withType(ACTION_TYPE, new EnumWrappers.IndexedEnumConverter<>(Action.class, ACTION_TYPE)).read(0);
    }

    /**
     * Sets the value of field 'action'
     *
     * @param value New value for field 'action'
     */
    public void setAction(Action value) {
        this.handle.getModifier().withType(ACTION_TYPE, new EnumWrappers.IndexedEnumConverter<>(Action.class, ACTION_TYPE)).write(0, value);
    }

    /**
     * Retrieves the value of field 'entries'
     *
     * @return 'entries'
     */
    public List<String> getEntries() {
        return this.handle.getLists(Converters.passthrough(String.class)).read(0);
    }

    /**
     * Sets the value of field 'entries'
     *
     * @param value New value for field 'entries'
     */
    public void setEntries(List<String> value) {
        this.handle.getLists(Converters.passthrough(String.class)).write(0, value);
    }

    public enum Action {
        ADD,
        REMOVE,
        SET;
    }
}
