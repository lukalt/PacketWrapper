package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

public class WrapperPlayServerWorldEvent extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.WORLD_EVENT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerWorldEvent() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerWorldEvent(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the type of the action to perform.
     * A list of all actions can be found here: <a href="https://wiki.vg/Protocol#World_Event">https://wiki.vg/Protocol#World_Event</a>
     *
     * @return 'type'
     */
    public int getType() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the type of the action to perform.
     * A list of all actions can be found here: <a href="https://wiki.vg/Protocol#World_Event">https://wiki.vg/Protocol#World_Event</a>
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
