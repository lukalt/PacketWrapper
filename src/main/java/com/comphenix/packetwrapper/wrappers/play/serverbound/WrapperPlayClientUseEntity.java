package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import org.bukkit.entity.Interaction;

public class WrapperPlayClientUseEntity extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.USE_ENTITY;

    public WrapperPlayClientUseEntity() {
        super(TYPE);
    }

    public WrapperPlayClientUseEntity(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'entityId'
     *
     * @return 'entityId'
     */
    public int getEntityId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'entityId'
     *
     * @param value New value for field 'entityId'
     */
    public void setEntityId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'action'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     * @deprecated {Use {@link WrapperPlayClientUseEntity#getAction()} instead}
     * @return 'action'
     */
    public InternalStructure getActionInternal() {
        return this.handle.getStructures().read(0);
    }

    /**
     * Sets the value of field 'action'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     * @deprecated {Use {@link WrapperPlayClientUseEntity#setAction(WrappedEnumEntityUseAction)} instead}
     * @param value New value for field 'action'
     */
    public void setAction(InternalStructure value) {
        this.handle.getStructures().write(0, value);
    }

    /**
     * Retrieves the value of field 'action'
     *
     * @return 'action'
     */
    public WrappedEnumEntityUseAction getAction() {
        return this.handle.getEnumEntityUseActions().read(0);
    }

    /**
     * Sets the value of field 'action'
     *
     * @param value New value for field 'action'
     */
    public void setAction(WrappedEnumEntityUseAction value) {
        this.handle.getEnumEntityUseActions().write(0, value);
    }

    /**
     * Retrieves the value of field 'usingSecondaryAction'
     *
     * @return 'usingSecondaryAction'
     */
    public boolean getUsingSecondaryAction() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'usingSecondaryAction'
     *
     * @param value New value for field 'usingSecondaryAction'
     */
    public void setUsingSecondaryAction(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    public interface WrappedUseAction {
        WrappedEnumEntityUseAction getType();
    }


}
