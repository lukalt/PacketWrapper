package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.ProtocolConversion;
import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerEntityHeadRotation extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_HEAD_ROTATION;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerEntityHeadRotation() {
        super(TYPE);
    }

    public WrapperPlayServerEntityHeadRotation(PacketContainer packet) {
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
     * Retrieves the value of field 'yHeadRot'
     *
     * @return 'yHeadRot'
     */
    public byte getYHeadRot() {
        return this.handle.getBytes().read(0);
    }

    /**
     * Gets the rotation of the head in degrees between 0.0 deg and 1.0 deg.
     *
     * @return head rotation in degree
     */
    @UtilityMethod
    public float getYHeadRotAngle() {
        return ProtocolConversion.angleToDegrees(this.getYHeadRot());
    }

    /**
     * Sets the value of field 'yHeadRot'
     *
     * @param value New value for field 'yHeadRot'
     */
    public void setYHeadRot(byte value) {
        this.handle.getBytes().write(0, value);
    }

    /**
     * Sets the rotation of the head in degrees between 0.0 deg and 1.0 deg.
     *
     * @param newAngle rotation of head in degree
     */
    @UtilityMethod
    public void setYHeadRotAngle(float newAngle) {
        this.setYHeadRot(ProtocolConversion.degreesToAngle(newAngle));
    }

}
