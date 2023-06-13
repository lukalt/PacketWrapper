package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

public class WrapperPlayServerOpenSignEditor extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.OPEN_SIGN_EDITOR;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerOpenSignEditor() {
        super(TYPE);
    }

    public WrapperPlayServerOpenSignEditor(PacketContainer packet) {
        super(packet, TYPE);
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
     * Gets the field front text
     * @since 1.20
     * @return whether the opened editor is for the front or on the back of the sign
     */
    public boolean getIsFrontText() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the field front text
     * @since 1.20
     * @param value whether the opened editor is for the front or on the back of the sign
     */
    public void setIsFrontText(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
