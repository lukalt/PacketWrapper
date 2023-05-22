package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

import java.util.UUID;

/**
 * Send by the client to the server if the player (in spectator mode) wants to teleport to a target player
 */
public class WrapperPlayClientSpectate extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.SPECTATE;

    public WrapperPlayClientSpectate() {
        super(TYPE);
    }

    public WrapperPlayClientSpectate(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the uuid of the target player
     *
     * @return 'uuid' of target players
     */
    public UUID getUuid() {
        return this.handle.getUUIDs().read(0);
    }

    /**
     * Sets the uuid of the target player
     *
     * @param value uuid of target player
     */
    public void setUuid(UUID value) {
        this.handle.getUUIDs().write(0, value);
    }

}
