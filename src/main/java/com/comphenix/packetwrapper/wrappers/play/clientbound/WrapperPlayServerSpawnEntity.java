package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.EntityType;

import java.util.UUID;

public class WrapperPlayServerSpawnEntity extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SPAWN_ENTITY;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSpawnEntity() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSpawnEntity(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'id'
     *
     * @return 'id'
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'id'
     *
     * @param value New value for field 'id'
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'uuid'
     *
     * @return 'uuid'
     */
    public UUID getUuid() {
        return this.handle.getUUIDs().read(0);
    }

    /**
     * Sets the value of field 'uuid'
     *
     * @param value New value for field 'uuid'
     */
    public void setUuid(UUID value) {
        this.handle.getUUIDs().write(0, value);
    }

    /**
     * Retrieves the value of field 'type'
     *
     * @return 'type'
     */
    public EntityType getType() {
        return this.handle.getEntityTypeModifier().read(0);
    }

    /**
     * Sets the value of field 'type'
     *
     * @param value New value for field 'type'
     */
    public void setType(EntityType value) {
        this.handle.getEntityTypeModifier().write(0, value);
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
     * Retrieves the value of field 'xa'
     *
     * @return 'xa'
     */
    public int getXa() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'xa'
     *
     * @param value New value for field 'xa'
     */
    public void setXa(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'ya'
     *
     * @return 'ya'
     */
    public int getYa() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'ya'
     *
     * @param value New value for field 'ya'
     */
    public void setYa(int value) {
        this.handle.getIntegers().write(2, value);
    }

    /**
     * Retrieves the value of field 'za'
     *
     * @return 'za'
     */
    public int getZa() {
        return this.handle.getIntegers().read(3);
    }

    /**
     * Sets the value of field 'za'
     *
     * @param value New value for field 'za'
     */
    public void setZa(int value) {
        this.handle.getIntegers().write(3, value);
    }

    /**
     * Retrieves the value of field 'xRot'
     *
     * @return 'xRot'
     */
    public byte getXRot() {
        return this.handle.getBytes().read(0);
    }

    /**
     * Sets the value of field 'xRot'
     *
     * @param value New value for field 'xRot'
     */
    public void setXRot(byte value) {
        this.handle.getBytes().write(0, value);
    }

    /**
     * Retrieves the value of field 'yRot'
     *
     * @return 'yRot'
     */
    public byte getYRot() {
        return this.handle.getBytes().read(1);
    }

    /**
     * Sets the value of field 'yRot'
     *
     * @param value New value for field 'yRot'
     */
    public void setYRot(byte value) {
        this.handle.getBytes().write(1, value);
    }

    /**
     * Retrieves the value of field 'yHeadRot'
     *
     * @return 'yHeadRot'
     */
    public byte getYHeadRot() {
        return this.handle.getBytes().read(2);
    }

    /**
     * Sets the value of field 'yHeadRot'
     *
     * @param value New value for field 'yHeadRot'
     */
    public void setYHeadRot(byte value) {
        this.handle.getBytes().write(2, value);
    }

    /**
     * Retrieves the value of field 'data'
     *
     * @return 'data'
     */
    public int getData() {
        return this.handle.getIntegers().read(4);
    }

    /**
     * Sets the value of field 'data'
     *
     * @param value New value for field 'data'
     */
    public void setData(int value) {
        this.handle.getIntegers().write(4, value);
    }

}
