package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerKickDisconnect extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.KICK_DISCONNECT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerKickDisconnect() {
        super(TYPE);
    }

    public WrapperPlayServerKickDisconnect(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'reason'
     *
     * @return 'reason'
     */
    public WrappedChatComponent getReason() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'reason'
     *
     * @param value New value for field 'reason'
     */
    public void setReason(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

}
