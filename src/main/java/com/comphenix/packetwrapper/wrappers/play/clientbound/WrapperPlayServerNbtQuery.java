package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerNbtQuery extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.NBT_QUERY;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerNbtQuery() {
        super(TYPE);
    }

    public WrapperPlayServerNbtQuery(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'transactionId'
     *
     * @return 'transactionId'
     */
    public int getTransactionId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'transactionId'
     *
     * @param value New value for field 'transactionId'
     */
    public void setTransactionId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'tag'
     *
     * @return 'tag'
     */
    public WrappedChatComponent[] getTag() {
        return this.handle.getChatComponentArrays().read(0);
    }

    /**
     * Sets the value of field 'tag'
     *
     * @param value New value for field 'tag'
     */
    public void setTag(WrappedChatComponent[] value) {
        this.handle.getChatComponentArrays().write(0, value);
    }

}
