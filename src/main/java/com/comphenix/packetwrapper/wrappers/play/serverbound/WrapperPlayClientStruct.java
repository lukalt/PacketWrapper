package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.Vector3I;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.Rotation;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.block.structure.UsageMode;

public class WrapperPlayClientStruct extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.STRUCT;
    private static final Class<?> STRUCTURE_MODE_CLASS = MinecraftReflection.getNullableNMS("world.level.block.state.properties.StructureMode", "world.level.block.state.properties.BlockPropertyStructureMode");
    private static final Class<?> STRUCTURE_MODE_UPDATE_TYPE_CLASS = MinecraftReflection.getNullableNMS("world.level.block.entity.StructureBlockEntity$UpdateType", "world.level.block.entity.TileEntityStructure$UpdateType");


    private final static Class<?> MIRROR_CLASS = MinecraftReflection.getMinecraftClass("world.level.block.Mirror", "world.level.block.EnumBlockMirror");
    private final static EquivalentConverter<Mirror> MIRROR_ENUM_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(Mirror.class, MIRROR_CLASS);
    private final static Class<?> ROTATION_CLASS = MinecraftReflection.getMinecraftClass("world.level.block.Rotation", "world.level.block.EnumBlockRotation");
    private final static EquivalentConverter<StructureRotation> ROTATION_ENUM_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(StructureRotation.class, ROTATION_CLASS);

    public WrapperPlayClientStruct() {
        super(TYPE);
    }

    public WrapperPlayClientStruct(PacketContainer packet) {
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
     * Retrieves the value of field 'updateType'
     *
     * @return 'updateType'
     */
    public UpdateType getUpdateType() {
        return this.handle.getModifier().withType(STRUCTURE_MODE_UPDATE_TYPE_CLASS, new EnumWrappers.IndexedEnumConverter<>(UpdateType.class, STRUCTURE_MODE_UPDATE_TYPE_CLASS)).read(0);
    }

    /**
     * Sets the value of field 'updateType'
     *
     * @param value New value for field 'updateType'
     */
    public void setUpdateType(UpdateType value) {
        this.handle.getModifier().withType(STRUCTURE_MODE_UPDATE_TYPE_CLASS, new EnumWrappers.IndexedEnumConverter<>(UpdateType.class, STRUCTURE_MODE_UPDATE_TYPE_CLASS)).write(0, value);
    }

    /**
     * Retrieves the value of field 'mode'
     *
     * @return 'mode'
     */
    public UsageMode getMode() {
        return this.handle.getModifier().withType(STRUCTURE_MODE_CLASS, new EnumWrappers.IndexedEnumConverter<>(UsageMode.class, STRUCTURE_MODE_CLASS)).read(0);
    }

    /**
     * Sets the value of field 'mode'
     *
     * @param value New value for field 'mode'
     */
    public void setMode(UsageMode value) {
        this.handle.getModifier().withType(STRUCTURE_MODE_CLASS, new EnumWrappers.IndexedEnumConverter<>(UsageMode.class, STRUCTURE_MODE_CLASS)).write(0, value);
    }

    /**
     * Retrieves the value of field 'name'
     *
     * @return 'name'
     */
    public String getName() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'name'
     *
     * @param value New value for field 'name'
     */
    public void setName(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'offset'
     *
     * @return 'offset'
     */
    public BlockPosition getOffset() {
        return this.handle.getBlockPositionModifier().read(1);
    }

    /**
     * Sets the value of field 'offset'
     *
     * @param value New value for field 'offset'
     */
    public void setOffset(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(1, value);
    }

    /**
     * Retrieves the value of field 'size'
     *
     * @return 'size'
     */
    public Vector3I getSize() {
        return this.handle.getModifier().withType(Vector3I.HANDLE_TYPE, Vector3I.getConverter()).read(0);
    }

    /**
     * Sets the value of field 'size'
     *
     * @param value New value for field 'size'
     */
    public void setSize(Vector3I value) {
        this.handle.getModifier().withType(Vector3I.HANDLE_TYPE, Vector3I.getConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'mirror'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     * @deprecated {Use {@link WrapperPlayClientStruct#getMirror()} instead}
     * @return 'mirror'
     */
    @Deprecated
    public InternalStructure getMirrorInternal() {
        return this.handle.getStructures().read(6);
    }

    /**
     * Sets the value of field 'mirror'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     * @deprecated {Use {@link WrapperPlayClientStruct#setMirror(Mirror)} instead}
     * @param value New value for field 'mirror'
     */
    @Deprecated
    public void setMirrorInternal(InternalStructure value) {
        this.handle.getStructures().write(6, value);
    }

    /**
     * Retrieves the value of field 'mirror'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'mirror'
     */
    public Mirror getMirror() {
        return this.handle.getModifier().withType(MIRROR_CLASS, MIRROR_ENUM_CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'mirror'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'mirror'
     */
    public void setMirror(Mirror value) {
        this.handle.getModifier().withType(MIRROR_CLASS, MIRROR_ENUM_CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'rotation'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     * @deprecated Use {@link WrapperPlayClientStruct#getRotation()} instead
     * @return 'rotation'
     */
    @Deprecated
    public InternalStructure getRotationInternal() {
        return this.handle.getStructures().read(7);
    }

    /**
     * Sets the value of field 'rotation'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     * @deprecated Use {@link WrapperPlayClientStruct#setRotation(StructureRotation)} instead
     * @param value New value for field 'rotation'
     */
    @Deprecated
    public void setRotationInternal(InternalStructure value) {
        this.handle.getStructures().write(7, value);
    }

    /**
     * Retrieves the value of field 'rotation'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'rotation'
     */
    public StructureRotation getRotation() {
        return this.handle.getModifier().withType(ROTATION_CLASS, ROTATION_ENUM_CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'rotation'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'rotation'
     */
    public void setRotation(StructureRotation value) {
        this.handle.getModifier().withType(ROTATION_CLASS, ROTATION_ENUM_CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'data'
     *
     * @return 'data'
     */
    public String getData() {
        return this.handle.getStrings().read(1);
    }

    /**
     * Sets the value of field 'data'
     *
     * @param value New value for field 'data'
     */
    public void setData(String value) {
        this.handle.getStrings().write(1, value);
    }

    /**
     * Retrieves the value of field 'ignoreEntities'
     *
     * @return 'ignoreEntities'
     */
    public boolean getIgnoreEntities() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'ignoreEntities'
     *
     * @param value New value for field 'ignoreEntities'
     */
    public void setIgnoreEntities(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'showAir'
     *
     * @return 'showAir'
     */
    public boolean getShowAir() {
        return this.handle.getBooleans().read(1);
    }

    /**
     * Sets the value of field 'showAir'
     *
     * @param value New value for field 'showAir'
     */
    public void setShowAir(boolean value) {
        this.handle.getBooleans().write(1, value);
    }

    /**
     * Retrieves the value of field 'showBoundingBox'
     *
     * @return 'showBoundingBox'
     */
    public boolean getShowBoundingBox() {
        return this.handle.getBooleans().read(2);
    }

    /**
     * Sets the value of field 'showBoundingBox'
     *
     * @param value New value for field 'showBoundingBox'
     */
    public void setShowBoundingBox(boolean value) {
        this.handle.getBooleans().write(2, value);
    }

    /**
     * Retrieves the value of field 'integrity'
     *
     * @return 'integrity'
     */
    public float getIntegrity() {
        return this.handle.getFloat().read(0);
    }

    /**
     * Sets the value of field 'integrity'
     *
     * @param value New value for field 'integrity'
     */
    public void setIntegrity(float value) {
        this.handle.getFloat().write(0, value);
    }

    /**
     * Retrieves the value of field 'seed'
     *
     * @return 'seed'
     */
    public long getSeed() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the value of field 'seed'
     *
     * @param value New value for field 'seed'
     */
    public void setSeed(long value) {
        this.handle.getLongs().write(0, value);
    }

    public enum UpdateType {
        UPDATE_DATA,
        SAVE_AREA,
        LOAD_AREA,
        SCAN_AREA;
    }
}
