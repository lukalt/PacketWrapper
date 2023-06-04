package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerUpdateTime extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.UPDATE_TIME;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerUpdateTime() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerUpdateTime(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'gameTime'
     *
     * @return 'gameTime'
     */
    public long getGameTime() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the value of field 'gameTime'
     *
     * @param value New value for field 'gameTime'
     */
    public void setGameTime(long value) {
        this.handle.getLongs().write(0, value);
    }

    /**
     * Retrieves the value of field 'dayTime'
     *
     * @return 'dayTime'
     */
    public long getDayTime() {
        return this.handle.getLongs().read(1);
    }

    /**
     * Sets the value of field 'dayTime'
     *
     * @param value New value for field 'dayTime'
     */
    public void setDayTime(long value) {
        this.handle.getLongs().write(1, value);
    }

}
