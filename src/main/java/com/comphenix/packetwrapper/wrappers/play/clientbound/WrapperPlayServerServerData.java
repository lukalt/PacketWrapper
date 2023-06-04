package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.Converters;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

import javax.annotation.Nullable;
import java.util.Optional;

public class WrapperPlayServerServerData extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SERVER_DATA;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerServerData() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerServerData(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'motd'
     *
     * @return 'motd'
     */
    public WrappedChatComponent getMotd() {
        return this.handle.getChatComponents().read(0);
    }

    /**
     * Sets the value of field 'motd'
     *
     * @param value New value for field 'motd'
     */
    public void setMotd(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

    /**
     * Retrieves the value of field 'iconBytes'
     *
     * @return 'iconBytes'
     */
    public Optional<byte[]> getIconBytes() {
        return this.handle.getOptionals(Converters.passthrough(byte[].class)).read(0);
    }

    /**
     * Sets the value of field 'iconBytes'
     *
     * @param value New value for field 'iconBytes'
     */
    public void setIconBytes(@Nullable byte[] value) {
        this.handle.getOptionals(Converters.passthrough(byte[].class)).write(0, Optional.ofNullable(value));
    }

    /**
     * Retrieves the value of field 'enforcesSecureChat'
     *
     * @return 'enforcesSecureChat'
     */
    public boolean getEnforcesSecureChat() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'enforcesSecureChat'
     *
     * @param value New value for field 'enforcesSecureChat'
     */
    public void setEnforcesSecureChat(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

}
