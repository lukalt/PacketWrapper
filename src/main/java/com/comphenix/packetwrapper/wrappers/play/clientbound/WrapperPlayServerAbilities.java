package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerAbilities extends AbstractPacket {
    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ABILITIES;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerAbilities() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerAbilities(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'invulnerable'
     *
     * @return 'invulnerable'
     */
    public boolean getInvulnerable() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'invulnerable'
     *
     * @param value New value for field 'invulnerable'
     */
    public void setInvulnerable(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'isFlying'
     *
     * @return 'isFlying'
     */
    public boolean getIsFlying() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Sets the value of field 'isFlying'
     *
     * @param value New value for field 'isFlying'
     */
    public void setIsFlying(boolean value) {
        this.handle.getBooleans().write(1, value);
    }

    /**
     * Retrieves the value of field 'canFly'
     *
     * @return 'canFly'
     */
    public boolean getCanFly() {
        return this.handle.getBooleans().read(2);
    }

    /**
     * Sets the value of field 'canFly'
     *
     * @param value New value for field 'canFly'
     */
    public void setCanFly(boolean value) {
        this.handle.getBooleans().write(2, value);
    }

    /**
     * Retrieves the value of field 'instabuild'
     *
     * @return 'instabuild'
     */
    public boolean getInstabuild() {
        return this.handle.getBooleans().read(3);
    }

    /**
     * Sets the value of field 'instabuild'
     *
     * @param value New value for field 'instabuild'
     */
    public void setInstabuild(boolean value) {
        this.handle.getBooleans().write(3, value);
    }

    /**
     * Retrieves the value of field 'flyingSpeed'
     *
     * @return 'flyingSpeed'
     */
    public float getFlyingSpeed() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'flyingSpeed'
     *
     * @param value New value for field 'flyingSpeed'
     */
    public void setFlyingSpeed(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'walkingSpeed'
     *
     * @return 'walkingSpeed'
     */
    public float getWalkingSpeed() {
        return this.handle.getFloat().read(1);
    }

    /**
     * Sets the value of field 'walkingSpeed'
     *
     * @param value New value for field 'walkingSpeed'
     */
    public void setWalkingSpeed(float value) {
        this.handle.getFloat().write(1, value);
    }

}
