package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Unused packet
 */
public class WrapperPlayServerPlayerCombatEnter extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_COMBAT_ENTER;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPlayerCombatEnter() {
        super(TYPE);
    }

    public WrapperPlayServerPlayerCombatEnter(PacketContainer packet) {
        super(packet, TYPE);
    }


}
