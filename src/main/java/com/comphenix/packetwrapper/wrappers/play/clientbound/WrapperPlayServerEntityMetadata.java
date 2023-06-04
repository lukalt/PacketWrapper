package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedDataValue;

import java.util.List;

/**
 * Send by server to client to update the entity metadata for a previously spawned entity
 */
public class WrapperPlayServerEntityMetadata extends AbstractPacket {

    /**
     * The type of this packet
     */
    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_METADATA;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerEntityMetadata() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerEntityMetadata(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets the id of the entity for which to modify metadata
     *
     * @return entity id
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the id of the entity for which to modify metadata
     *
     * @param value entity id
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves a list of metadata values to update
     *
     * @return 'packedItems' list of metadata values
     */
    public List<WrappedDataValue> getPackedItems() {
        return this.handle.getDataValueCollectionModifier().read(0);
    }

    /**
     * Sets the list of metadata values to update
     *
     * @param value List of metadata values
     */
    public void setPackedItems(List<WrappedDataValue> value) {
        this.handle.getDataValueCollectionModifier().write(0, value);
    }
}
