package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.WrappedLastSeenMessagesUpdate;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedMessageSignature;

import java.time.Instant;

/**
 * Sents by client to server when the player sends a (signed) chat messages
 */
public class WrapperPlayClientChat extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.CHAT;

    public WrapperPlayClientChat() {
        super(TYPE);
    }

    public WrapperPlayClientChat(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets the raw message (max length: 256)
     *
     * @return raw message
     */
    public String getMessage() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the raw message (max length: 256)
     *
     * @param value raw message
     */
    public void setMessage(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'timeStamp'
     *
     * @return 'timeStamp'
     */
    public Instant getTimeStamp() {
        return this.handle.getInstants().read(0);
    }

    /**
     * Sets the value of field 'timeStamp'
     *
     * @param value New value for field 'timeStamp'
     */
    public void setTimeStamp(Instant value) {
        this.handle.getInstants().write(0, value);
    }

    /**
     * Gets the salt to verify signatures
     *
     * @return 'salt'
     */
    public long getSalt() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the salt to verify signatures
     *
     * @param value New value for field 'salt'
     */
    public void setSalt(long value) {
        this.handle.getLongs().write(0, value);
    }

    /**
     * Gets the signature used to sign this message
     *
     * @return 'signature'
     */
    public WrappedMessageSignature getSignature() {
        return this.handle.getMessageSignatures().read(0);
    }

    /**
     * Sets the signature used to sign this message
     *
     * @param value New value for field 'signature'
     */
    public void setSignature(WrappedMessageSignature value) {
        this.handle.getMessageSignatures().write(0, value);
    }



    /**
     * Retrieves the value of field 'lastSeenMessages'
     *
     * @return 'lastSeenMessages'
     * @deprecated {Use {@link WrapperPlayClientChatCommand#getLastSeenMessages()} instead}
     */
    public InternalStructure getLastSeenMessagesInternal() {
        return this.handle.getStructures().read(4);
    }

    /**
     * Sets the value of field 'lastSeenMessages'
     *
     * @param value New value for field 'lastSeenMessages'
     * @deprecated {Use {@link WrapperPlayClientChatCommand#setLastSeenMessages(WrappedLastSeenMessagesUpdate)} instead}
     */
    public void setLastSeenMessagesInternal(InternalStructure value) {
        this.handle.getStructures().write(4, value);
    }

    /**
     * Retrieves the value of field 'lastSeenMessages'
     *
     * @return 'lastSeenMessages'
     */
    public WrappedLastSeenMessagesUpdate getLastSeenMessages() {
        return this.handle.getModifier().withType(WrappedLastSeenMessagesUpdate.HANDLE_TYPE, WrappedLastSeenMessagesUpdate.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'lastSeenMessages'
     *
     * @param value New value for field 'lastSeenMessages'
     */
    public void setLastSeenMessages(WrappedLastSeenMessagesUpdate value) {
        this.handle.getModifier().withType(WrappedLastSeenMessagesUpdate.HANDLE_TYPE, WrappedLastSeenMessagesUpdate.CONVERTER).write(0, value);
    }
}
