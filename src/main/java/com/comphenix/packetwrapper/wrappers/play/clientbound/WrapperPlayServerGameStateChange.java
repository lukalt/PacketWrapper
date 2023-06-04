package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerGameStateChange extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.GAME_STATE_CHANGE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerGameStateChange() {
        super(TYPE);
    }

    public WrapperPlayServerGameStateChange(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'event'
     *
     * @return 'event'
     */
    public Integer getEvent() {
        return this.handle.getGameStateIDs().read(0);
    }

    /**
     * Sets the value of field 'event'
     *
     * @param value New value for field 'event'
     */
    public void setEvent(Integer value) {
        this.handle.getGameStateIDs().write(0, value);
    }

    /**
     * Retrieves the value of field 'param'
     *
     * @return 'param'
     */
    public float getParam() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'param'
     *
     * @param value New value for field 'param'
     */
    public void setParam(float value) {
        this.handle.getFloat().write(0, value);
    }

}
