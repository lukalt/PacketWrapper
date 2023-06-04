package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Sent whenever an entity should change animation.
 */
public class WrapperPlayServerAnimation extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ANIMATION;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerAnimation() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerAnimation(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Sets the id of the entity
     *
     * @return 'id'
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the id of the entity
     *
     * @param value New value for field 'id'
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the numerical index of the corresponding action
     *
     * @return 'action'
     */
    public int getActionId() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Retrieves the animation as an enum
     *
     * @return 'action'
     */
    @TestExclusion
    public Animation getAction() {
        return Animation.values()[getActionId()];
    }


    /**
     * Sets the numerical index of the corresponding animation
     *
     * @param value New value for field 'action'
     */
    public void setActionId(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Sets the animation
     *
     * @param value New value for field 'action'
     */
    @UtilityMethod
    public void setAction(Animation value) {
        this.setActionId(value.ordinal());
    }

    public enum Animation {
        SWING_MAIN_ARM,
        TAKE_DAMAGE,
        LEAVE_BED,
        SWING_OFFHAND,
        CRITICAL_EFFECT,
        MAGICAL_CRITICAL_EFFECT;

    }

}
