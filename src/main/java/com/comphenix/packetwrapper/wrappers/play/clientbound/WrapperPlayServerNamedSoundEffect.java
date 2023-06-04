package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers.SoundCategory;
import org.bukkit.Sound;

public class WrapperPlayServerNamedSoundEffect extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.NAMED_SOUND_EFFECT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerNamedSoundEffect() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerNamedSoundEffect(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'sound'
     *
     * @return 'sound'
     */
    public Sound getSound() {
        return this.handle.getHolders(MinecraftReflection.getSoundEffectClass(), BukkitConverters.getSoundConverter()).read(0);
    }

    /**
     * Sets the value of field 'sound'
     *
     * @param value New value for field 'sound'
     */
    public void setSound(Sound value) {
        this.handle.getHolders(MinecraftReflection.getSoundEffectClass(), BukkitConverters.getSoundConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'source'
     *
     * @return 'source'
     */
    public SoundCategory getSource() {
        return this.handle.getSoundCategories().read(0);
    }

    /**
     * Sets the value of field 'source'
     *
     * @param value New value for field 'source'
     */
    public void setSource(SoundCategory value) {
        this.handle.getSoundCategories().write(0, value);
    }

    /**
     * Retrieves the value of field 'x'
     *
     * @return 'x'
     */
    public int getX() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'x'
     *
     * @param value New value for field 'x'
     */
    public void setX(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'y'
     *
     * @return 'y'
     */
    public int getY() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'y'
     *
     * @param value New value for field 'y'
     */
    public void setY(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'z'
     *
     * @return 'z'
     */
    public int getZ() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'z'
     *
     * @param value New value for field 'z'
     */
    public void setZ(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'volume'
     *
     * @return 'volume'
     */
    public float getVolume() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'volume'
     *
     * @param value New value for field 'volume'
     */
    public void setVolume(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'pitch'
     *
     * @return 'pitch'
     */
    public float getPitch() {
        return this.handle.getFloat().read(1);
    }

    /**
     * Sets the value of field 'pitch'
     *
     * @param value New value for field 'pitch'
     */
    public void setPitch(float value) {
        this.handle.getFloat().write(1, value);
    }

    /**
     * Retrieves the value of field 'seed'
     *
     * @return 'seed'
     */
    public long getSeed() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the value of field 'seed'
     *
     * @param value New value for field 'seed'
     */
    public void setSeed(long value) {
        this.handle.getLongs().write(0, value);
    }

}
