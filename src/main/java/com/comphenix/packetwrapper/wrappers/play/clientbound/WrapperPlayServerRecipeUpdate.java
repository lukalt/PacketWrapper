package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;

import java.util.List;

public class WrapperPlayServerRecipeUpdate extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.RECIPE_UPDATE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRecipeUpdate() {
        super(TYPE);
    }

    public WrapperPlayServerRecipeUpdate(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'recipes'
     *
     * @return 'recipes'
     */
    public List<InternalStructure> getRecipesInternal() {
        return this.handle.getLists(InternalStructure.getConverter()).read(0); // TODO
    }

    /**
     * Sets the value of field 'recipes'
     *
     * @param value New value for field 'recipes'
     */
    public void setRecipesInternal(List<InternalStructure> value) {
        this.handle.getLists(InternalStructure.getConverter()).write(0, value); // TODO
    }

}
