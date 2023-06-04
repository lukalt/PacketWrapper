package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.inventory.ItemStack;

/**
 * Send by server to client when an item at a specific slot in a container should be updated
 */
public class WrapperPlayServerSetSlot extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SET_SLOT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetSlot() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSetSlot(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the id of the container to update
     *
     * @return 'containerId'
     */
    public int getContainerId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the id of the container to update
     *
     * @param value New value for field 'containerId'
     */
    public void setContainerId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'stateId'
     *
     * @return 'stateId'
     */
    public int getStateId() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'stateId'
     *
     * @param value New value for field 'stateId'
     */
    public void setStateId(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the index of the slot that should be updated
     *
     * @return 'slot'
     */
    public int getSlot() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the index of the slot that should be updated
     *
     * @param value New value for field 'slot'
     */
    public void setSlot(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'itemStack'
     *
     * @return 'itemStack'
     */
    public ItemStack getItemStack() {
        return this.handle.getItemModifier().read(0);
    }

    /**
     * Sets the value of field 'itemStack'
     *
     * @param value New value for field 'itemStack'
     */
    public void setItemStack(ItemStack value) {
        this.handle.getItemModifier().write(0, value);
    }

}
