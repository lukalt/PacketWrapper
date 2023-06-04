package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.Pair;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class WrapperPlayServerEntityEquipment extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_EQUIPMENT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerEntityEquipment() {
        super(TYPE);
    }

    public WrapperPlayServerEntityEquipment(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'entity'
     *
     * @return 'entity'
     */
    public int getEntity() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'entity'
     *
     * @param value New value for field 'entity'
     */
    public void setEntity(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'slots'
     *
     * @return 'slots'
     */
    public List<Pair<EnumWrappers.ItemSlot, ItemStack>> getSlots() {
        return this.handle.getLists(BukkitConverters.getPairConverter(EnumWrappers.getItemSlotConverter(), BukkitConverters.getItemStackConverter())).read(0);
    }

    /**
     * Sets the value of field 'slots'
     *
     * @param value New value for field 'slots'
     */
    public void setSlots(List<Pair<EnumWrappers.ItemSlot, ItemStack>> value) {
        this.handle.getLists(BukkitConverters.getPairConverter(EnumWrappers.getItemSlotConverter(), BukkitConverters.getItemStackConverter())).write(0, value);
    }

}
