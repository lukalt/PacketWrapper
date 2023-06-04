package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.ReflectiveAdventureComponentConverter;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

/**
 * Sents by server to client to update the header and footer in the tab list
 */
public class WrapperPlayServerPlayerListHeaderFooter extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPlayerListHeaderFooter() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerPlayerListHeaderFooter(PacketContainer packet) {
        super(packet, TYPE);
    }

    private boolean isUsingPaper() {
        return this.handle.getModifier().size() > 2;
    }

    /**
     * Retrieves the component that will be displayed above the tab list
     *
     * @return 'header'
     */
    public WrappedChatComponent getHeader() {
        WrappedChatComponent read = this.handle.getChatComponents().read(0);
        if (read != null) {
            return read;
        }
        return ReflectiveAdventureComponentConverter.fromComponent(this.handle.getModifier().read(2));
    }

    /**
     * Sets the component that will be displayed above the tab list
     *
     * @param value New value for field 'header'
     */
    public void setHeader(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
        if (isUsingPaper()) {
            this.handle.getModifier().write(2, null);
            Object footerNms = this.handle.getModifier().read(3);
            if (footerNms != null) {
                this.handle.getChatComponents().write(1, ReflectiveAdventureComponentConverter.fromComponent(footerNms));
            }
            this.handle.getModifier().write(3, null);
        }
    }

    /**
     * Retrieves the component that will be displayed below the tab list
     *
     * @return 'footer'
     */
    public WrappedChatComponent getFooter() {
        WrappedChatComponent read = this.handle.getChatComponents().read(1);
        if (read != null) {
            return read;
        }
        return ReflectiveAdventureComponentConverter.fromComponent(this.handle.getModifier().read(3));
    }

    /**
     * Sets the component that will be displayed below the tab list
     *
     * @param value New value for field 'footer'
     */
    public void setFooter(WrappedChatComponent value) {
        this.handle.getChatComponents().write(1, value);
        if (isUsingPaper()) {
            this.handle.getModifier().write(3, null);
            Object headerNms = this.handle.getModifier().read(2);
            if (headerNms != null) {
                this.handle.getChatComponents().write(0, ReflectiveAdventureComponentConverter.fromComponent(headerNms));
            }
            this.handle.getModifier().write(2, null);
        }
    }

}
