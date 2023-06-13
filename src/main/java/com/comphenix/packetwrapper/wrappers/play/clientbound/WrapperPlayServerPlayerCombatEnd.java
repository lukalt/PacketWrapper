package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * @deprecated Unused packet
 */
@Deprecated
public class WrapperPlayServerPlayerCombatEnd extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_COMBAT_END;

    private int dummyKillerId;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPlayerCombatEnd() {
        super(TYPE);
    }

    public WrapperPlayServerPlayerCombatEnd(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'killerId'
     * @deprecated Removed in 1.20
     * @return 'killerId'
     */
    public int getKillerId() {
        return this.dummyKillerId;
    }

    /**
     * Sets the value of field 'killerId'
     * @deprecated Removed in 1.20
     * @param value New value for field 'killerId'
     */
    public void setKillerId(int value) {
        this.dummyKillerId = value;
    }

    /**
     * Retrieves the value of field 'duration'
     *
     * @return 'duration'
     */
    public int getDuration() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'duration'
     *
     * @param value New value for field 'duration'
     */
    public void setDuration(int value) {
        this.handle.getIntegers().write(0, value);
    }

}
