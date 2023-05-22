package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerRelEntityMove extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.REL_ENTITY_MOVE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRelEntityMove() {
        super(TYPE);
    }

    public WrapperPlayServerRelEntityMove(PacketContainer packet) {
        super(packet, TYPE);
    }


}
