package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.TestExclusion;
import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers;

/**
 * Send by server to client to rotate the client player to face the given location or entity.
 */
public class WrapperPlayServerLookAt extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.LOOK_AT;
    private static final Class<?> ANCHOR_TYPE = MinecraftReflection.getMinecraftClass("commands.arguments.EntityAnchorArgument$Anchor", "commands.arguments.ArgumentAnchor$Anchor");

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerLookAt() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerLookAt(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'x'
     *
     * @return 'x'
     */
    public double getX() {
        return this.handle.getDoubles().read(0);
    }

    /**
     * Sets the value of field 'x'
     *
     * @param value New value for field 'x'
     */
    public void setX(double value) {
        this.handle.getDoubles().write(0, value);
    }

    /**
     * Retrieves the value of field 'y'
     *
     * @return 'y'
     */
    public double getY() {
        return this.handle.getDoubles().read(1);
    }

    /**
     * Sets the value of field 'y'
     *
     * @param value New value for field 'y'
     */
    public void setY(double value) {
        this.handle.getDoubles().write(1, value);
    }

    /**
     * Retrieves the value of field 'z'
     *
     * @return 'z'
     */
    public double getZ() {
        return this.handle.getDoubles().read(2);
    }

    /**
     * Sets the value of field 'z'
     *
     * @param value New value for field 'z'
     */
    public void setZ(double value) {
        this.handle.getDoubles().write(2, value);
    }

    /**
     * Retrieves the value of field 'entity'
     *
     * @return 'entity'
     */
    public int getEntity() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'entity'
     *
     * @param value New value for field 'entity'
     */
    public void setEntity(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'fromAnchor'
     *
     * @return 'fromAnchor'
     * @deprecated Use {@link #getFromAnchor()} instead
     */
    @Deprecated
    public InternalStructure getFromAnchorInternal() {
        return this.handle.getStructures().read(0);
    }

    /**
     * Sets the value of field 'fromAnchor'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'fromAnchor'
     * @deprecated Use {@link #setFromAnchor(Anchor)} instead
     */
    @Deprecated
    public void setFromAnchorInternal(InternalStructure value) {
        this.handle.getStructures().write(0, value);
    }

    /**
     * Retrieves the value of field 'toAnchor'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'toAnchor'
     * @deprecated Use {@link #getToAnchor()} instead
     */
    @Deprecated
    public InternalStructure getToAnchorInternal() {
        return this.handle.getStructures().read(1);
    }

    /**
     * Sets the value of field 'toAnchor'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'toAnchor'
     * @deprecated Use {@link #setToAnchor(Anchor)} instead
     */
    @Deprecated
    public void setToAnchorInternal(InternalStructure value) {
        this.handle.getStructures().write(1, value);
    }

    /**
     * Retrieves the value of field 'fromAnchor'
     *
     * @return 'fromAnchor'
     */
    @TestExclusion
    public Anchor getFromAnchor() {
        return this.getAnchors().read(0);
    }

    /**
     * Sets the value of field 'fromAnchor'
     *
     * @param value New value for field 'fromAnchor'
     */
    public void setFromAnchor(Anchor value) {
        this.getAnchors().write(0, value);
    }

    /**
     * Retrieves the value of field 'toAnchor'
     *
     * @return 'toAnchor'
     */
    @TestExclusion
    public Anchor getToAnchor() {
        return this.getAnchors().read(1);
    }

    /**
     * Sets the value of field 'toAnchor'
     *
     * @param value New value for field 'toAnchor'
     */
    public void setToAnchor(Anchor value) {
        this.getAnchors().write(1, value);
    }

    @UtilityMethod
    private StructureModifier<Anchor> getAnchors() {
        return this.handle.getModifier().withType(ANCHOR_TYPE, new EnumWrappers.IndexedEnumConverter<>(Anchor.class, ANCHOR_TYPE));
    }

    /**
     * Retrieves the value of field 'atEntity'
     *
     * @return 'atEntity'
     */
    public boolean getAtEntity() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'atEntity'
     *
     * @param value New value for field 'atEntity'
     */
    public void setAtEntity(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    public enum Anchor {
        FEET,
        EYES
    }

}
