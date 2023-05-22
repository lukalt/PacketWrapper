package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.EnumWrappers.ChatVisibility;

import java.util.EnumSet;

/**
 * Send by client to server after login or when client settings change.
 */
public class WrapperPlayClientSettings extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.SETTINGS;
    private static final Class<?> HUMANOID_ARM_CLASS = MinecraftReflection.getNullableNMS("world.entity.HumanoidArm", "world.entity.EnumMainHand");

    public WrapperPlayClientSettings() {
        super(TYPE);
    }

    public WrapperPlayClientSettings(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets the language selected in the client, e.g. "de_DE" or "en_US"
     *
     * @return 'language'
     */
    public String getLanguage() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the language selected in the client, e.g. "de_DE" or "en_US"
     *
     * @param value New value for field 'language'
     */
    public void setLanguage(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'viewDistance'
     *
     * @return 'viewDistance'
     */
    public int getViewDistance() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'viewDistance'
     *
     * @param value New value for field 'viewDistance'
     */
    public void setViewDistance(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the chat visibility
     *
     * @return 'chatVisibility'
     */
    public ChatVisibility getChatVisibility() {
        return this.handle.getChatVisibilities().read(0);
    }

    /**
     * Sets the chat visibility
     *
     * @param value New value for field 'chatVisibility'
     */
    public void setChatVisibility(ChatVisibility value) {
        this.handle.getChatVisibilities().write(0, value);
    }

    /**
     * Gets whether the client renders chat colors
     *
     * @return 'chatColors'
     */
    public boolean getChatColors() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets whether the client renders chat colors
     *
     * @param value New value for field 'chatColors'
     */
    public void setChatColors(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves a bit mask for displayed skin parts
     * Bit 0 (0x01): Cape enabled
     * Bit 1 (0x02): Jacket enabled
     * Bit 2 (0x04): Left Sleeve enabled
     * Bit 3 (0x08): Right Sleeve enabled
     * Bit 4 (0x10): Left Pants Leg enabled
     * Bit 5 (0x20): Right Pants Leg enabled
     * Bit 6 (0x40): Hat enabled
     *
     * @return 'modelCustomisation'
     */
    public int getModelCustomisation() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the bit mask for displayed skin parts
     * Bit 0 (0x01): Cape enabled
     * Bit 1 (0x02): Jacket enabled
     * Bit 2 (0x04): Left Sleeve enabled
     * Bit 3 (0x08): Right Sleeve enabled
     * Bit 4 (0x10): Left Pants Leg enabled
     * Bit 5 (0x20): Right Pants Leg enabled
     * Bit 6 (0x40): Hat enabled
     *
     * @param value New value for field 'modelCustomisation'
     */
    public void setModelCustomisation(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the main arm of the client
     *
     * @return 'mainHand'
     */
    public HumanoidArm getMainHand() {
        return this.handle.getModifier().withType(HUMANOID_ARM_CLASS, new EnumWrappers.IndexedEnumConverter<>(HumanoidArm.class, HUMANOID_ARM_CLASS)).read(0);
    }

    /**
     * Sets the main arm of the client
     *
     * @param value New value for field 'mainHand'
     */
    public void setMainHand(HumanoidArm value) {
        this.handle.getModifier().withType(HUMANOID_ARM_CLASS, new EnumWrappers.IndexedEnumConverter<>(HumanoidArm.class, HUMANOID_ARM_CLASS)).write(0, value);
    }

    /**
     * Gets whether filtering of content is enabled on client side
     *
     * @return 'textFilteringEnabled'
     */
    public boolean getTextFilteringEnabled() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Sets whether filtering of content is enabled on client side
     *
     * @param value New value for field 'textFilteringEnabled'
     */
    public void setTextFilteringEnabled(boolean value) {
        this.handle.getBooleans().write(1, value);
    }

    /**
     * Gets whether the client wants to appear in the server's public player list (player sample in server ping)
     *
     * @return 'allowsListing'
     */
    public boolean getAllowsListing() {
        return this.handle.getBooleans().read(2);
    }

    /**
     * Sets whether the client wants to appear in the server's public player list (player sample in server ping)
     *
     * @param value New value for field 'allowsListing'
     */
    public void setAllowsListing(boolean value) {
        this.handle.getBooleans().write(2, value);
    }

    /**
     * Enum representing the arm of a human
     */
    public enum HumanoidArm {
        /**
         * Left arm
         */
        LEFT,
        /**
         * Right arm
         */
        RIGHT
    }

}
