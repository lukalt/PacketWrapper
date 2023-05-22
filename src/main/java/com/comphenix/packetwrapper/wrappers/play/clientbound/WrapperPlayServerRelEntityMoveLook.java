package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerRelEntityMoveLook extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.REL_ENTITY_MOVE_LOOK;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRelEntityMoveLook() {
        super(TYPE);
    }

    public WrapperPlayServerRelEntityMoveLook(PacketContainer packet) {
        super(packet, TYPE);
    }


}
