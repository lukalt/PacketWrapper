package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerOpenWindow extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.OPEN_WINDOW;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerOpenWindow() {
        super(TYPE);
    }

    public WrapperPlayServerOpenWindow(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'containerId'
     *
     * @return 'containerId'
     */
    public int getContainerId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'containerId'
     *
     * @param value New value for field 'containerId'
     */
    public void setContainerId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'type'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'type'
     */
    public InternalStructure getTypeInternal() {
        return this.handle.getStructures().read(0); // TODO: No specific modifier has been found for type class net.minecraft.world.inventory.MenuType Generic type: [?]
    }

    /**
     * Sets the value of field 'type'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'type'
     */
    public void setTypeInternal(InternalStructure value) {
        this.handle.getStructures().write(0, value); // TODO: No specific modifier has been found for type class net.minecraft.world.inventory.MenuType Generic type: [?]
    }

    /**
     * Retrieves the value of field 'title'
     *
     * @return 'title'
     */
    public WrappedChatComponent getTitle() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'title'
     *
     * @param value New value for field 'title'
     */
    public void setTitle(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

}
