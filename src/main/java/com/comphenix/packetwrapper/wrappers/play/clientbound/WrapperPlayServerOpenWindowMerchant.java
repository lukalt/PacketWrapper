package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;

public class WrapperPlayServerOpenWindowMerchant extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.OPEN_WINDOW_MERCHANT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerOpenWindowMerchant() {
        super(TYPE);
    }

    public WrapperPlayServerOpenWindowMerchant(PacketContainer packet) {
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
     * Retrieves the value of field 'offers'
     *
     * @return 'offers'
     */
    public List<MerchantRecipe> getOffers() {
        return this.handle.getMerchantRecipeLists().read(0);
    }

    /**
     * Sets the value of field 'offers'
     *
     * @param value New value for field 'offers'
     */
    public void setOffers(List<MerchantRecipe> value) {
        this.handle.getMerchantRecipeLists().write(0, value);
    }

    /**
     * Retrieves the value of field 'villagerLevel'
     *
     * @return 'villagerLevel'
     */
    public int getVillagerLevel() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'villagerLevel'
     *
     * @param value New value for field 'villagerLevel'
     */
    public void setVillagerLevel(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'villagerXp'
     *
     * @return 'villagerXp'
     */
    public int getVillagerXp() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'villagerXp'
     *
     * @param value New value for field 'villagerXp'
     */
    public void setVillagerXp(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'showProgress'
     *
     * @return 'showProgress'
     */
    public boolean getShowProgress() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'showProgress'
     *
     * @param value New value for field 'showProgress'
     */
    public void setShowProgress(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'canRestock'
     *
     * @return 'canRestock'
     */
    public boolean getCanRestock() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Sets the value of field 'canRestock'
     *
     * @param value New value for field 'canRestock'
     */
    public void setCanRestock(boolean value) {
        this.handle.getBooleans().write(1, value);
    }

}
