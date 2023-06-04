package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Sent by the server to the client to instruct the client to render from the entity identified by the provided id
 * perspective.
 */
public class WrapperPlayServerCamera extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.CAMERA;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerCamera() {
        super(TYPE);
    }

    public WrapperPlayServerCamera(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets the id of the entity to spectate
     *
     * @return 'cameraId'
     */
    public int getCameraId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the entity id of the entity to spectate
     *
     * @param value New value for field 'cameraId'
     */
    public void setCameraId(int value) {
        this.handle.getIntegers().write(0, value);
    }

}
