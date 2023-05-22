package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.Difficulty;

public class WrapperPlayServerServerDifficulty extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.SERVER_DIFFICULTY;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerServerDifficulty() {
        super(TYPE);
    }

    public WrapperPlayServerServerDifficulty(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'difficulty'
     *
     * @return 'difficulty'
     */
    public Difficulty getDifficulty() {
        return this.handle.getDifficulties().read(0);
    }

    /**
     * Sets the value of field 'difficulty'
     *
     * @param value New value for field 'difficulty'
     */
    public void setDifficulty(Difficulty value) {
        this.handle.getDifficulties().write(0, value);
    }

    /**
     * Retrieves the value of field 'locked'
     *
     * @return 'locked'
     */
    public boolean getLocked() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'locked'
     *
     * @param value New value for field 'locked'
     */
    public void setLocked(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
