package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerSetActionBarText extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.SET_ACTION_BAR_TEXT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetActionBarText() {
        super(TYPE);
    }

    public WrapperPlayServerSetActionBarText(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'text'
     *
     * @return 'text'
     */
    public WrappedChatComponent getText() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'text'
     *
     * @param value New value for field 'text'
     */
    public void setText(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

    /**
     * Retrieves the value of field 'adventure$text'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'adventure$text'
     */
    public InternalStructure getAdventure$textInternal() {
        return this.handle.getStructures().read(1); // TODO: No specific modifier has been found for type interface net.kyori.adventure.text.Component Generic type: interface net.kyori.adventure.text.Component
    }

    /**
     * Sets the value of field 'adventure$text'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'adventure$text'
     */
    public void setAdventure$textInternal(InternalStructure value) {
        this.handle.getStructures().write(1, value); // TODO: No specific modifier has been found for type interface net.kyori.adventure.text.Component Generic type: interface net.kyori.adventure.text.Component
    }

    /**
     * Retrieves the value of field 'components'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'components'
     */
    public InternalStructure getComponentsInternal() {
        return this.handle.getStructures().read(2); // TODO: No specific modifier has been found for type class [Lnet.md_5.bungee.api.chat.BaseComponent; Generic type: class [Lnet.md_5.bungee.api.chat.BaseComponent;
    }

    /**
     * Sets the value of field 'components'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'components'
     */
    public void setComponentsInternal(InternalStructure value) {
        this.handle.getStructures().write(2, value); // TODO: No specific modifier has been found for type class [Lnet.md_5.bungee.api.chat.BaseComponent; Generic type: class [Lnet.md_5.bungee.api.chat.BaseComponent;
    }

}
