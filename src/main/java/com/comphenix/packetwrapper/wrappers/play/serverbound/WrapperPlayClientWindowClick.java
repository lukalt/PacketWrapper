package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.util.MoreConverters;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import org.bukkit.inventory.ItemStack;

public class WrapperPlayClientWindowClick extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.WINDOW_CLICK;

    public WrapperPlayClientWindowClick() {
        super(TYPE);
    }

    public WrapperPlayClientWindowClick(PacketContainer packet) {
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
     * Retrieves the value of field 'slotNum'
     *
     * @return 'slotNum'
     */
    public int getSlotNum() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'slotNum'
     *
     * @param value New value for field 'slotNum'
     */
    public void setSlotNum(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'buttonNum'
     *
     * @return 'buttonNum'
     */
    public int getButtonNum() {
        return this.handle.getIntegers().read(3);
    }

    /**
     * Sets the value of field 'buttonNum'
     *
     * @param value New value for field 'buttonNum'
     */
    public void setButtonNum(int value) {
        this.handle.getIntegers().write(3, value);
    }

    /**
     * Retrieves the value of field 'clickType'
     * @deprecated {Use {@link WrapperPlayClientWindowClick#getClickType()} instead}
     * @return 'clickType'
     */
    @Deprecated
    public InternalStructure getClickTypeInternal() {
        return this.handle.getStructures().read(0);
    }

    /**
     * Sets the value of field 'clickType'
     * @deprecated {Use {@link WrapperPlayClientWindowClick#setClickType(WrappedClickType)} instead}
     * @param value New value for field 'clickType'
     */
    @Deprecated
    public void setClickType(InternalStructure value) {
        this.handle.getStructures().write(0, value);
    }

    /**
     * Retrieves the value of field 'clickType'
     *
     * @return 'clickType'
     */
    public WrappedClickType getClickType() {
        return this.handle.getModifier().withType(CLICK_TYPE_CLASS, CLICK_TYPE_CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'clickType'
     *
     * @param value New value for field 'clickType'
     */
    public void setClickType(WrappedClickType value) {
        this.handle.getModifier().withType(CLICK_TYPE_CLASS, CLICK_TYPE_CONVERTER).write(0, value);
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

    /**
     * Retrieves the value of field 'changedSlots'
     *
     * @return 'changedSlots'
     */
    public Int2ObjectMap<ItemStack> getChangedSlots() {
        return this.getInt2ObjectMaps(BukkitConverters.getItemStackConverter()).read(0);
    }

    /**
     * Sets the value of field 'changedSlots'
     *
     * @param value New value for field 'changedSlots'
     */
    public void setChangedSlots(Int2ObjectMap<ItemStack> value) {
        this.getInt2ObjectMaps(BukkitConverters.getItemStackConverter()).write(0, value);
    }

    private <T> StructureModifier<Int2ObjectMap<T>> getInt2ObjectMaps(EquivalentConverter<T> valueConverter) {
        return this.handle.getModifier().withType(Int2ObjectMap.class, MoreConverters.getInt2ObjectMapConverter(valueConverter));
    }

    private final static Class<?> CLICK_TYPE_CLASS = MinecraftReflection.getMinecraftClass("world.inventory.ClickType", "world.inventory.InventoryClickType");
    private final static EquivalentConverter<WrappedClickType> CLICK_TYPE_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(WrappedClickType.class, CLICK_TYPE_CLASS);
    public enum WrappedClickType {
        PICKUP,
        QUICK_MOVE,
        SWAP,
        CLONE,
        THROW,
        QUICK_CRAFT,
        PICKUP_ALL;
    }


}
