package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetTitlesAnimation extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SET_TITLES_ANIMATION;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetTitlesAnimation() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSetTitlesAnimation(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the number of ticks the title is faded in
     *
     * @return 'fadeIn'
     */
    public int getFadeIn() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the number of ticks the title is faded in
     *
     * @param value New value for field 'fadeIn'
     */
    public void setFadeIn(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the number of ticks the title stays on screen
     *
     * @return 'stay'
     */
    public int getStay() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the number of ticks the title stays on screen
     *
     * @param value New value for field 'stay'
     */
    public void setStay(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the number of ticks to fade out the title
     *
     * @return 'fadeOut'
     */
    public int getFadeOut() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the number of ticks to fade out the title
     *
     * @param value New value for field 'fadeOut'
     */
    public void setFadeOut(int value) {
        this.handle.getIntegers().write(2, value);
    }

}
