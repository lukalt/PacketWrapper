package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Material;

/**
 * This packet is used for a number of actions and animations performed by blocks, usually non-persistent. The client ignores the provided block type and instead uses the block state in their world.
 *
 * @link <a href="https://wiki.vg/Block_Actions">https://wiki.vg/Block_Actions</a>
 */
public class WrapperPlayServerBlockAction extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.BLOCK_ACTION;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerBlockAction() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerBlockAction(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the position of the block.
     *
     * @return 'pos'
     */
    public BlockPosition getPos() {
        return this.handle.getBlockPositionModifier().read(0);
    }

    /**
     * Sets the position of the block.
     *
     * @param value New value for field 'pos'
     */
    public void setPos(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    /**
     * Retrieves the action to perform
     *
     * @return 'b0' action index to perform
     */
    public int getB0() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the action to perform
     *
     * @param value Sets the index of the action to perform
     */
    public void setB0(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the parameter for the action retrieved by @link{getB0(int)}
     *
     * @return 'b1'
     */
    public int getB1() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the parameter for the action specified by @link{setB0(int)}
     *
     * @param value New value for field 'b1'
     */
    public void setB1(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the type of the block.
     *
     * @return 'block'
     */
    public Material getBlock() {
        return this.handle.getBlocks().read(0);
    }

    /**
     * Sets the type of the block.
     *
     * @param value New value for field 'block'
     */
    public void setBlock(Material value) {
        this.handle.getBlocks().write(0, value);
    }

}
