package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.Converters;

import java.util.List;
import java.util.UUID;

/**
 * Send by server to client to remove player info data (from the tab list)
 */
public class WrapperPlayServerPlayerInfoRemove extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_INFO_REMOVE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPlayerInfoRemove() {
        super(TYPE);
    }

    public WrapperPlayServerPlayerInfoRemove(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets list of player uuids to remove
     *
     * @return list of player uuids to remove
     */
    public List<UUID> getProfileIds() {
        return this.handle.getLists(Converters.passthrough(UUID.class)).read(0);
    }

    /**
     * Sets list of player uuids to remove
     *
     * @param value list of player uuids to remove.
     */
    public void setProfileIds(List<UUID> value) {
        this.handle.getLists(Converters.passthrough(UUID.class)).write(0, value);
    }

}
