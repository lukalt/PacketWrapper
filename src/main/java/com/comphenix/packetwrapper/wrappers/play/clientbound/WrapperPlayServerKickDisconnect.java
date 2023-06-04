package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

/**
 * Send by server to client to disconnect the client. The specified message will be shown on the disconnect screen.
 */
public class WrapperPlayServerKickDisconnect extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.KICK_DISCONNECT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerKickDisconnect() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerKickDisconnect(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the kick reason shown on the disconnect screen
     *
     * @return 'reason'
     */
    public WrappedChatComponent getReason() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the kick reason shown on the disconnect screen
     *
     * @param value New value for field 'reason'
     */
    public void setReason(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

}
