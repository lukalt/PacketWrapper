package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.ReflectiveAdventureComponentConverter;
import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerSystemChat extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SYSTEM_CHAT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSystemChat() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSystemChat(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the message to be sent encoded as a JSON string
     *
     * @return 'content' as JSON string
     */
    public String getContent() {
        String read = this.handle.getStrings().read(0);
        if (read != null) {
            return read;
        }
        return ReflectiveAdventureComponentConverter.componentToString(this.handle.getStructures().read(0).getHandle());
    }

    /**
     * Sets the message content as a JSON encoded string
     *
     * @param value New value for field 'content'
     */
    public void setContent(String value) {
        if (isUsingPaper()) {
            // We are using paper. Remove adventure component
            this.handle.getModifier().write(0, null);
        }
        this.handle.getStrings().write(0, value);
    }

    /**
     * Gets the content of the system message as a chat component
     *
     * @return content of the system message
     */
    @UtilityMethod
    public WrappedChatComponent getContentComponent() {
        return WrappedChatComponent.fromJson(this.getContent());
    }

    /**
     * Sets the content of the system message
     *
     * @param component content of the system message
     */
    @UtilityMethod
    public void setContentComponent(WrappedChatComponent component) {
        this.setContent(component.getJson());
    }

    private boolean isUsingPaper() {
        return !(this.handle.getModifier().read(0) instanceof String);
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
