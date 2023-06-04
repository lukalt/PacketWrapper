package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.potion.PotionEffectType;

public class WrapperPlayServerRemoveEntityEffect extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.REMOVE_ENTITY_EFFECT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRemoveEntityEffect() {
        super(TYPE);
    }

    public WrapperPlayServerRemoveEntityEffect(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'entityId'
     *
     * @return 'entityId'
     */
    public int getEntityId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'entityId'
     *
     * @param value New value for field 'entityId'
     */
    public void setEntityId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'effect'
     *
     * @return 'effect'
     */
    public PotionEffectType getEffect() {
        return this.handle.getEffectTypes().read(0);
    }

    /**
     * Sets the value of field 'effect'
     *
     * @param value New value for field 'effect'
     */
    public void setEffect(PotionEffectType value) {
        this.handle.getEffectTypes().write(0, value);
    }

}
