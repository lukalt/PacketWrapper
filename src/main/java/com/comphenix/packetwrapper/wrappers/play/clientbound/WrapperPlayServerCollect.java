package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerCollect extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.COLLECT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerCollect() {
        super(TYPE);
    }

    public WrapperPlayServerCollect(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'itemId'
     *
     * @return 'itemId'
     */
    public int getItemId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'itemId'
     *
     * @param value New value for field 'itemId'
     */
    public void setItemId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'playerId'
     *
     * @return 'playerId'
     */
    public int getPlayerId() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'playerId'
     *
     * @param value New value for field 'playerId'
     */
    public void setPlayerId(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'amount'
     *
     * @return 'amount'
     */
    public int getAmount() {
        return this.handle.getIntegers().read(2);
    }

    /**
     * Sets the value of field 'amount'
     *
     * @param value New value for field 'amount'
     */
    public void setAmount(int value) {
        this.handle.getIntegers().write(2, value);
    }

}
