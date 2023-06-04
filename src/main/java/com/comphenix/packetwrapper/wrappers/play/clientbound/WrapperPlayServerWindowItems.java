package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BukkitConverters;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class WrapperPlayServerWindowItems extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.WINDOW_ITEMS;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerWindowItems() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerWindowItems(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'containerId'
     *
     * @return 'containerId'
     */
    public int getContainerId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'containerId'
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
     * Retrieves the value of field 'items'
     *
     * @return 'items'
     */
    public List<ItemStack> getItems() {
        return this.handle.getLists(BukkitConverters.getItemStackConverter()).read(0);
    }

    /**
     * Sets the value of field 'items'
     *
     * @param value New value for field 'items'
     */
    public void setItems(List<ItemStack> value) {
        this.handle.getLists(BukkitConverters.getItemStackConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'carriedItem'
     *
     * @return 'carriedItem'
     */
    public ItemStack getCarriedItem() {
        return this.handle.getItemModifier().read(0);
    }

    /**
     * Sets the value of field 'carriedItem'
     *
     * @param value New value for field 'carriedItem'
     */
    public void setCarriedItem(ItemStack value) {
        this.handle.getItemModifier().write(0, value);
    }

}
