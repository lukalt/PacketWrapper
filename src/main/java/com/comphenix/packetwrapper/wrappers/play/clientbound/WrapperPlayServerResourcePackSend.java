package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerResourcePackSend extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.RESOURCE_PACK_SEND;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerResourcePackSend() {
        super(TYPE);
    }

    public WrapperPlayServerResourcePackSend(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'url'
     *
     * @return 'url'
     */
    public String getUrl() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'url'
     *
     * @param value New value for field 'url'
     */
    public void setUrl(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'hash'
     *
     * @return 'hash'
     */
    public String getHash() {
        return this.handle.getStrings().read(1);
    }

    /**
     * Sets the value of field 'hash'
     *
     * @param value New value for field 'hash'
     */
    public void setHash(String value) {
        this.handle.getStrings().write(1, value);
    }

    /**
     * Retrieves the value of field 'required'
     *
     * @return 'required'
     */
    public boolean getRequired() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'required'
     *
     * @param value New value for field 'required'
     */
    public void setRequired(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'prompt'
     *
     * @return 'prompt'
     */
    public WrappedChatComponent getPrompt() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'prompt'
     *
     * @param value New value for field 'prompt'
     */
    public void setPrompt(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

}
