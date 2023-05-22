package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetTitlesAnimation extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.SET_TITLES_ANIMATION;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetTitlesAnimation() {
        super(TYPE);
    }

    public WrapperPlayServerSetTitlesAnimation(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'fadeIn'
     *
     * @return 'fadeIn'
     */
    public int getFadeIn() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'fadeIn'
     *
     * @param value New value for field 'fadeIn'
     */
    public void setFadeIn(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'stay'
     *
     * @return 'stay'
     */
    public int getStay() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'stay'
     *
     * @param value New value for field 'stay'
     */
    public void setStay(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'fadeOut'
     *
     * @return 'fadeOut'
     */
    public int getFadeOut() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'fadeOut'
     *
     * @param value New value for field 'fadeOut'
     */
    public void setFadeOut(int value) {
        this.handle.getIntegers().write(2, value);
    }

}
