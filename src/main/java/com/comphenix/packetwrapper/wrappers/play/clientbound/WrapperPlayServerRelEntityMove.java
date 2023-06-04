package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Sent by the server when an entity moves less than 8 blocks; if an entity moves more than 8 blocks {@link WrapperPlayServerEntityTeleport} should be sent instead.
 */
public class WrapperPlayServerRelEntityMove extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.REL_ENTITY_MOVE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRelEntityMove() {
        super(TYPE);
    }

    public WrapperPlayServerRelEntityMove(PacketContainer packet) {
        super(packet, TYPE);
    }

    public int getEntityId() {
        return this.handle.getIntegers().read(0);
    }

    public void setEntityId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    public short getDeltaX() {
        return this.handle.getShorts().read(0);
    }

    public void setDeltaX(short value) {
        this.handle.getShorts().write(0, value);
    }

    public short getDeltaY() {
        return this.handle.getShorts().read(1);
    }

    public void setDeltaY(short value) {
        this.handle.getShorts().write(1, value);
    }

    public short getDeltaZ() {
        return this.handle.getShorts().read(2);
    }

    public void setDeltaZ(short value) {
        this.handle.getShorts().write(2, value);
    }

    public boolean getOnGround() {
        return this.handle.getBooleans().read(0);
    }

    public void setOnGround(boolean value) {
        this.handle.getBooleans().write(0, value);
    }


}
