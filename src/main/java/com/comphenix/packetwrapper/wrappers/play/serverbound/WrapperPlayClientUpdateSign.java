package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

public class WrapperPlayClientUpdateSign extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.UPDATE_SIGN;

    public WrapperPlayClientUpdateSign() {
        super(TYPE);
    }

    public WrapperPlayClientUpdateSign(PacketContainer packet) {
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
     * Gets the face of the sign to update
     * @since 1.20
     * @return whether the front (true) or on the back (false) of the sign is updated
     */
    public boolean getFrontText() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the face of the sign to update
     * @since 1.20
     * @param value whether the front (true) or on the back (false) of the sign is updated
     */
    public void setFrontText(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'lines'
     *
     * @return 'lines'
     */
    public String[] getLines() {
        return this.handle.getStringArrays().read(0);
    }

    /**
     * Sets the value of field 'lines'
     *
     * @param value New value for field 'lines'
     */
    public void setLines(String[] value) {
        this.handle.getStringArrays().write(0, value);
    }

}
