package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.WrappedSoundEvent;
import com.comphenix.packetwrapper.wrappers.handshaking.WrapperHandshakingClientSetProtocol;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;

import java.util.List;

public class WrapperPlayServerExplosion extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.EXPLOSION;

    public enum BlockInteraction {
        KEEP, DESTROY, DESTROY_WITH_DECAY, TRIGGER_BLOCK
    }
    private static final Class<?> BLOCK_INTERACTION_CLASS = MinecraftReflection.getNullableNMS("world.level.Explosion$BlockInteraction", "world.level.Explosion$BlockInteraction");
    private static final EquivalentConverter<BlockInteraction> BLOCK_INTERACTION_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(BlockInteraction.class, BLOCK_INTERACTION_CLASS);


    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerExplosion() {
        super(TYPE);
    }

    public WrapperPlayServerExplosion(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'x'
     *
     * @return 'x'
     */
    public double getX() {
        return this.handle.getDoubles().read(0);
    }

    /**
     * Sets the value of field 'x'
     *
     * @param value New value for field 'x'
     */
    public void setX(double value) {
        this.handle.getDoubles().write(0, value);
    }

    /**
     * Retrieves the value of field 'y'
     *
     * @return 'y'
     */
    public double getY() {
        return this.handle.getDoubles().read(1);
    }

    /**
     * Sets the value of field 'y'
     *
     * @param value New value for field 'y'
     */
    public void setY(double value) {
        this.handle.getDoubles().write(1, value);
    }

    /**
     * Retrieves the value of field 'z'
     *
     * @return 'z'
     */
    public double getZ() {
        return this.handle.getDoubles().read(2);
    }

    /**
     * Sets the value of field 'z'
     *
     * @param value New value for field 'z'
     */
    public void setZ(double value) {
        this.handle.getDoubles().write(2, value);
    }

    /**
     * Retrieves the value of field 'power'
     *
     * @return 'power'
     */
    public float getPower() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'power'
     *
     * @param value New value for field 'power'
     */
    public void setPower(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'toBlow'
     *
     * @return 'toBlow'
     */
    public List<BlockPosition> getToBlow() {
        return this.handle.getLists(BlockPosition.getConverter()).read(0);
    }

    /**
     * Sets the value of field 'toBlow'
     *
     * @param value New value for field 'toBlow'
     */
    public void setToBlow(List<BlockPosition> value) {
        this.handle.getLists(BlockPosition.getConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'knockbackX'
     *
     * @return 'knockbackX'
     */
    public float getKnockbackX() {
        return this.handle.getFloat().read(1);
    }

    /**
     * Sets the value of field 'knockbackX'
     *
     * @param value New value for field 'knockbackX'
     */
    public void setKnockbackX(float value) {
        this.handle.getFloat().write(1, value);
    }

    /**
     * Retrieves the value of field 'knockbackY'
     *
     * @return 'knockbackY'
     */
    public float getKnockbackY() {
        return this.handle.getFloat().read(2);
    }

    /**
     * Sets the value of field 'knockbackY'
     *
     * @param value New value for field 'knockbackY'
     */
    public void setKnockbackY(float value) {
        this.handle.getFloat().write(2, value);
    }

    /**
     * Retrieves the value of field 'knockbackZ'
     *
     * @return 'knockbackZ'
     */
    public float getKnockbackZ() {
        return this.handle.getFloat().read(3);
    }

    /**
     * Sets the value of field 'knockbackZ'
     *
     * @param value New value for field 'knockbackZ'
     */
    public void setKnockbackZ(float value) {
        this.handle.getFloat().write(3, value);
    }



    public BlockInteraction getBlockInteraction() {
        return this.handle.getModifier().withType(BLOCK_INTERACTION_CLASS, BLOCK_INTERACTION_CONVERTER).read(0);
    }

    public void setBlockInteraction(BlockInteraction interaction) {
        this.handle.getModifier().withType(BLOCK_INTERACTION_CLASS, BLOCK_INTERACTION_CONVERTER).write(0, interaction);
    }

    public WrappedSoundEvent getExplosionSound() {
        return this.handle.getModifier().withType(WrappedSoundEvent.SOUND_EVENT_CLASS, WrappedSoundEvent.CONVERTER).read(0);
    }

    public void setExplosionSound(WrappedSoundEvent explosionSound) {
        this.handle.getModifier().withType(WrappedSoundEvent.SOUND_EVENT_CLASS, WrappedSoundEvent.CONVERTER).write(0, explosionSound);
    }
    // TODO: new fields
    /*
    net.minecraft.core.particles.ParticleOptions smallExplosionParticles
    net.minecraft.core.particles.ParticleOptions largeExplosionParticles
     */

}
