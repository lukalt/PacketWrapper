package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.MinecraftKey;

public class WrapperPlayClientSetJigsaw extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.SET_JIGSAW;
    private static final Class<?> JOINT_TYPE_CLASS = MinecraftReflection.getNullableNMS("world.level.block.entity.JigsawBlockEntity$JointType", "world.level.block.entity.TileEntityJigsaw$JointType");

    public WrapperPlayClientSetJigsaw() {
        super(TYPE);
    }

    public WrapperPlayClientSetJigsaw(PacketContainer packet) {
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
     * Retrieves the value of field 'name'
     *
     * @return 'name'
     */
    public MinecraftKey getName() {
        return this.handle.getMinecraftKeys().read(0);
    }

    /**
     * Sets the value of field 'name'
     *
     * @param value New value for field 'name'
     */
    public void setName(MinecraftKey value) {
        this.handle.getMinecraftKeys().write(0, value);
    }

    /**
     * Retrieves the value of field 'target'
     *
     * @return 'target'
     */
    public MinecraftKey getTarget() {
        return this.handle.getMinecraftKeys().read(1);
    }

    /**
     * Sets the value of field 'target'
     *
     * @param value New value for field 'target'
     */
    public void setTarget(MinecraftKey value) {
        this.handle.getMinecraftKeys().write(1, value);
    }

    /**
     * Retrieves the value of field 'pool'
     *
     * @return 'pool'
     */
    public MinecraftKey getPool() {
        return this.handle.getMinecraftKeys().read(2);
    }

    /**
     * Sets the value of field 'pool'
     *
     * @param value New value for field 'pool'
     */
    public void setPool(MinecraftKey value) {
        this.handle.getMinecraftKeys().write(2, value);
    }

    /**
     * Retrieves the value of field 'finalState'
     *
     * @return 'finalState'
     */
    public String getFinalState() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'finalState'
     *
     * @param value New value for field 'finalState'
     */
    public void setFinalState(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'joint'
     *
     * @return 'joint'
     */
    public JointType getJoint() {
        return this.handle.getModifier().withType(JOINT_TYPE_CLASS, new EnumWrappers.IndexedEnumConverter<>(JointType.class, JOINT_TYPE_CLASS)).read(0);
    }

    /**
     * Sets the value of field 'joint'
     *
     * @param value New value for field 'joint'
     */
    public void setJoint(JointType value) {
        this.handle.getModifier().withType(JOINT_TYPE_CLASS, new EnumWrappers.IndexedEnumConverter<>(JointType.class, JOINT_TYPE_CLASS)).write(0, value);
    }

    public enum JointType {
        ROLLABLE,
        ALIGNED
    }

    public int getSelectionPriority() {
        return this.handle.getIntegers().read(0);
    }

    public void setSelectionPriority(int priority) {
        this.handle.getIntegers().write(0, priority);
    }

    public int getPlacementPriority() {
        return this.handle.getIntegers().read(1);
    }

    public void setPlacementPriority(int priority) {
        this.handle.getIntegers().write(1, priority);
    }

}
