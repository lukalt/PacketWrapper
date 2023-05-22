package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSystemChat extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.SYSTEM_CHAT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSystemChat() {
        super(TYPE);
    }

    public WrapperPlayServerSystemChat(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'adventure$content'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'adventure$content'
     */
    public InternalStructure getAdventure$contentInternal() {
        return this.handle.getStructures().read(0); // TODO: No specific modifier has been found for type interface net.kyori.adventure.text.Component Generic type: interface net.kyori.adventure.text.Component
    }

    /**
     * Sets the value of field 'adventure$content'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'adventure$content'
     */
    public void setAdventure$contentInternal(InternalStructure value) {
        this.handle.getStructures().write(0, value); // TODO: No specific modifier has been found for type interface net.kyori.adventure.text.Component Generic type: interface net.kyori.adventure.text.Component
    }

    /**
     * Retrieves the value of field 'content'
     *
     * @return 'content'
     */
    public String getContent() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'content'
     *
     * @param value New value for field 'content'
     */
    public void setContent(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'overlay'
     *
     * @return 'overlay'
     */
    public boolean getOverlay() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'overlay'
     *
     * @param value New value for field 'overlay'
     */
    public void setOverlay(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
