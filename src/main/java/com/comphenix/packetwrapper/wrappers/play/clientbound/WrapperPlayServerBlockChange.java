package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;

/**
 * Fired whenever a block is changed within the render distance.
 */
public class WrapperPlayServerBlockChange extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.BLOCK_CHANGE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerBlockChange() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerBlockChange(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the position of the block.
     *
     * @return position of block
     */
    public BlockPosition getPos() {
        return this.handle.getBlockPositionModifier().read(0);
    }

    /**
     * Sets the position of the block
     *
     * @param value position of block
     */
    public void setPos(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    /**
     * Retrieves the new block state
     *
     * @return 'blockState'
     */
    public WrappedBlockData getBlockState() {
        return this.handle.getBlockData().read(0);
    }

    /**
     * Sets the new block state
     *
     * @param value New value for field 'blockState'
     */
    public void setBlockState(WrappedBlockData value) {
        this.handle.getBlockData().write(0, value);
    }

}
