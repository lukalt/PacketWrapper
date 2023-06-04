package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerInitializeBorder extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.INITIALIZE_BORDER;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerInitializeBorder() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerInitializeBorder(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'newCenterX'
     *
     * @return 'newCenterX'
     */
    public double getNewCenterX() {
        return this.handle.getDoubles().read(0);
    }

    /**
     * Sets the value of field 'newCenterX'
     *
     * @param value New value for field 'newCenterX'
     */
    public void setNewCenterX(double value) {
        this.handle.getDoubles().write(0, value);
    }

    /**
     * Retrieves the value of field 'newCenterZ'
     *
     * @return 'newCenterZ'
     */
    public double getNewCenterZ() {
        return this.handle.getDoubles().read(1);
    }

    /**
     * Sets the value of field 'newCenterZ'
     *
     * @param value New value for field 'newCenterZ'
     */
    public void setNewCenterZ(double value) {
        this.handle.getDoubles().write(1, value);
    }

    /**
     * Retrieves the value of field 'oldSize'
     *
     * @return 'oldSize'
     */
    public double getOldSize() {
        return this.handle.getDoubles().read(2);
    }

    /**
     * Sets the value of field 'oldSize'
     *
     * @param value New value for field 'oldSize'
     */
    public void setOldSize(double value) {
        this.handle.getDoubles().write(2, value);
    }

    /**
     * Retrieves the value of field 'newSize'
     *
     * @return 'newSize'
     */
    public double getNewSize() {
        return this.handle.getDoubles().read(3);
    }

    /**
     * Sets the value of field 'newSize'
     *
     * @param value New value for field 'newSize'
     */
    public void setNewSize(double value) {
        this.handle.getDoubles().write(3, value);
    }

    /**
     * Retrieves the value of field 'lerpTime'
     *
     * @return 'lerpTime'
     */
    public long getLerpTime() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the value of field 'lerpTime'
     *
     * @param value New value for field 'lerpTime'
     */
    public void setLerpTime(long value) {
        this.handle.getLongs().write(0, value);
    }

    /**
     * Retrieves the value of field 'newAbsoluteMaxSize'
     *
     * @return 'newAbsoluteMaxSize'
     */
    public int getNewAbsoluteMaxSize() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'newAbsoluteMaxSize'
     *
     * @param value New value for field 'newAbsoluteMaxSize'
     */
    public void setNewAbsoluteMaxSize(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'warningBlocks'
     *
     * @return 'warningBlocks'
     */
    public int getWarningBlocks() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'warningBlocks'
     *
     * @param value New value for field 'warningBlocks'
     */
    public void setWarningBlocks(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'warningTime'
     *
     * @return 'warningTime'
     */
    public int getWarningTime() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'warningTime'
     *
     * @param value New value for field 'warningTime'
     */
    public void setWarningTime(int value) {
        this.handle.getIntegers().write(2, value);
    }

}
