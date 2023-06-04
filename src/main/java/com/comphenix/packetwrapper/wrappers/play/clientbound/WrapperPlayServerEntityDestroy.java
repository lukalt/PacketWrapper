package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.Converters;
import it.unimi.dsi.fastutil.ints.IntList;

/**
 * Sent by the server to client to remove one or more entities.
 */
public class WrapperPlayServerEntityDestroy extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_DESTROY;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerEntityDestroy() {
        super(TYPE);
    }

    public WrapperPlayServerEntityDestroy(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets a list of entity ids to remove
     *
     * @return 'entityIds' to remove
     */
    public IntList getEntityIds() {
        return this.handle.getModifier().withType(IntList.class, Converters.passthrough(IntList.class)).read(0);
    }

    /**
     * Sets the list of entity ids to remove
     *
     * @param value New value for field 'entityIds'
     */
    public void setEntityIds(IntList value) {
        this.handle.getModifier().withType(IntList.class, Converters.passthrough(IntList.class)).write(0, value);
    }

}
