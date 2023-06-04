package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.WrappedBoundChatType;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerDisguisedChat extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.DISGUISED_CHAT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerDisguisedChat() {
        super(TYPE);
    }

    public WrapperPlayServerDisguisedChat(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'message'
     *
     * @return 'message'
     */
    public WrappedChatComponent getMessage() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'message'
     *
     * @param value New value for field 'message'
     */
    public void setMessage(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

    /**
     * Retrieves the value of field 'chatType'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'chatType'
     * @deprecated Use {@link #getChatType()} instead
     */
    @Deprecated
    public InternalStructure getChatTypeInternal() {
        return this.handle.getStructures().read(1);
    }

    /**
     * Sets the value of field 'chatType'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'chatType'
     * @deprecated Use {@link #setChatType(WrappedBoundChatType)} instead
     */
    @Deprecated
    public void setChatTypeInternal(InternalStructure value) {
        this.handle.getStructures().write(1, value);
    }

    /**
     * Retrieves the value of field 'chatType'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'chatType'
     */
    public WrappedBoundChatType getChatType() {
        return this.handle.getModifier().withType(WrappedBoundChatType.HANDLE_TYPE, WrappedBoundChatType.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'chatType'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'chatType'
     */
    public void setChatType(WrappedBoundChatType value) {
        this.handle.getModifier().withType(WrappedBoundChatType.HANDLE_TYPE, WrappedBoundChatType.CONVERTER).write(0, value);
    }

}
