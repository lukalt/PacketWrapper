package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerExperience extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.EXPERIENCE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerExperience() {
        super(TYPE);
    }

    public WrapperPlayServerExperience(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'experienceProgress'
     *
     * @return 'experienceProgress'
     */
    public float getExperienceProgress() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'experienceProgress'
     *
     * @param value New value for field 'experienceProgress'
     */
    public void setExperienceProgress(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'totalExperience'
     *
     * @return 'totalExperience'
     */
    public int getTotalExperience() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'totalExperience'
     *
     * @param value New value for field 'totalExperience'
     */
    public void setTotalExperience(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'experienceLevel'
     *
     * @return 'experienceLevel'
     */
    public int getExperienceLevel() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'experienceLevel'
     *
     * @param value New value for field 'experienceLevel'
     */
    public void setExperienceLevel(int value) {
        this.handle.getIntegers().write(1, value);
    }

}
