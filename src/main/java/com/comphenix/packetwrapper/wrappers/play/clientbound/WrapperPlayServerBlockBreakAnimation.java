package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;

/**
 * Updates the block break animation progress for a specific block. The client will animate this progress.
 */
public class WrapperPlayServerBlockBreakAnimation extends AbstractPacket {
    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.BLOCK_BREAK_ANIMATION;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerBlockBreakAnimation() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerBlockBreakAnimation(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'id'
     *
     * @return 'id'
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'id'
     *
     * @param value New value for field 'id'
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
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
     * Sets the ID of the entity breaking the block.
     *
     * @param value New value for field 'pos'
     */
    public void setPos(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    /**
     * Retrieves the ID of the entity breaking the block.
     *
     * @return 'progress'  0–9 to set it, any other value to remove it.
     */
    public int getProgress() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'progress' 0–9 are the displayable destroy stages and each other number means that there is no animation on this coordinate.
     *
     * @param value New value for field 'progress'  0–9 to set it, any other value to remove it.
     */
    public void setProgress(int value) {
        this.handle.getIntegers().write(1, value);
    }

}
