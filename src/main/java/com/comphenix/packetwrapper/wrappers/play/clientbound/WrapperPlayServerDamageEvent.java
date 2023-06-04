package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BukkitConverters;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.Optional;

public class WrapperPlayServerDamageEvent extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.DAMAGE_EVENT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerDamageEvent() {
        super(TYPE);
    }

    public WrapperPlayServerDamageEvent(PacketContainer packet) {
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
     * Retrieves the value of field 'sourceTypeId'
     *
     * @return 'sourceTypeId'
     */
    public int getSourceTypeId() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'sourceTypeId'
     *
     * @param value New value for field 'sourceTypeId'
     */
    public void setSourceTypeId(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'sourceCauseId'
     *
     * @return 'sourceCauseId'
     */
    public int getSourceCauseId() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'sourceCauseId'
     *
     * @param value New value for field 'sourceCauseId'
     */
    public void setSourceCauseId(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'sourceDirectId'
     *
     * @return 'sourceDirectId'
     */
    public int getSourceDirectId() {
        return this.handle.getIntegers().read(3);
    }

    /**
     * Sets the value of field 'sourceDirectId'
     *
     * @param value New value for field 'sourceDirectId'
     */
    public void setSourceDirectId(int value) {
        this.handle.getIntegers().write(3, value);
    }

    /**
     * Retrieves the value of field 'sourcePosition'
     *
     * @return 'sourcePosition'
     */
    public Optional<Vector> getSourcePosition() {
        return this.handle.getOptionals(BukkitConverters.getVectorConverter()).read(0);
    }

    /**
     * Sets the value of field 'sourcePosition'
     *
     * @param value New value for field 'sourcePosition'
     */
    public void setSourcePosition(@Nullable Vector value) {
        this.handle.getOptionals(BukkitConverters.getVectorConverter()).write(0, Optional.ofNullable(value));
    }

}
