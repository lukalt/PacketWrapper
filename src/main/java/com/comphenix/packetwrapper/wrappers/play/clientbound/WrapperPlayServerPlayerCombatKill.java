package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

/**
 * Unused packet
 */
public class WrapperPlayServerPlayerCombatKill extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_COMBAT_KILL;

    private int dummyKillerId;

    public WrapperPlayServerPlayerCombatKill() {
        super(TYPE);
    }

    public WrapperPlayServerPlayerCombatKill(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'playerId'
     *
     * @return 'playerId'
     */
    public int getPlayerId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'playerId'
     *
     * @param value New value for field 'playerId'
     */
    public void setPlayerId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'killerId'
     * @deprecated Removed in 1.20
     * @return 'killerId'
     */
    @Deprecated
    public int getKillerId() {
        return this.dummyKillerId;
    }

    /**
     * Sets the value of field 'killerId'
     * @deprecated Removed in 1.20
     * @param value New value for field 'killerId'
     */
    @Deprecated
    public void setKillerId(int value) {
        this.dummyKillerId = value;
    }

    /**
     * Retrieves the value of field 'message'
     *
     * @return 'message'
     */
    public WrappedChatComponent getMessage() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'message'
     *
     * @param value New value for field 'message'
     */
    public void setMessage(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

}
