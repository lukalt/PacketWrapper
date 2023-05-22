package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

public class WrapperPlayServerWorldEvent extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.WORLD_EVENT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerWorldEvent() {
        super(TYPE);
    }

    public WrapperPlayServerWorldEvent(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'type'
     *
     * @return 'type'
     */
    public int getType() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'type'
     *
     * @param value New value for field 'type'
     */
    public void setType(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'pos'
     *
     * @return 'pos'
     */
    public BlockPosition getPos() {
        return this.handle.getBlockPositionModifier().read(0);
    }

    /**
     * Sets the value of field 'pos'
     *
     * @param value New value for field 'pos'
     */
    public void setPos(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    /**
     * Retrieves the value of field 'data'
     *
     * @return 'data'
     */
    public int getData() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'data'
     *
     * @param value New value for field 'data'
     */
    public void setData(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'globalEvent'
     *
     * @return 'globalEvent'
     */
    public boolean getGlobalEvent() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'globalEvent'
     *
     * @param value New value for field 'globalEvent'
     */
    public void setGlobalEvent(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
