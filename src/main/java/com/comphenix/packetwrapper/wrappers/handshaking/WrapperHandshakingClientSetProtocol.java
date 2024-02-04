package com.comphenix.packetwrapper.wrappers.handshaking;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Protocol;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers;

public class WrapperHandshakingClientSetProtocol extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Handshake.Client.SET_PROTOCOL;

    private static final Class<?> INTENTION_CLASS = MinecraftReflection.getNullableNMS("network.protocol.handshake.ClientIntent", "network.ConnectionProtocol");

    public enum Intention  {
        STATUS_NEXT,
        LOGIN_NEXT
    }
    private static final EquivalentConverter<Intention> INTENTION_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(Intention.class, INTENTION_CLASS);


    public WrapperHandshakingClientSetProtocol() {
        super(TYPE);
    }

    public WrapperHandshakingClientSetProtocol(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'protocolVersion'
     *
     * @return 'protocolVersion'
     */
    public int getProtocolVersion() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'protocolVersion'
     *
     * @param value New value for field 'protocolVersion'
     */
    public void setProtocolVersion(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'hostName'
     *
     * @return 'hostName'
     */
    public String getHostName() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'hostName'
     *
     * @param value New value for field 'hostName'
     */
    public void setHostName(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'port'
     *
     * @return 'port'
     */
    public int getPort() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'port'
     *
     * @param value New value for field 'port'
     */
    public void setPort(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves the value of field 'intention'
     * @deprecated
     * Use {@see WrapperHandshakingClientSetProtocol#getClientIntent} instead
     * @return 'intention'
     */
    @Deprecated
    public Protocol getIntention() {
        switch (getClientIntent()) {
            case LOGIN_NEXT -> {
                return Protocol.LOGIN;
            }
            case STATUS_NEXT -> {
                return Protocol.STATUS;
            }
        }
        throw new IllegalStateException("Invalid client intent");
    }

    public Intention getClientIntent() {
        return this.getIntentions().read(0);
    }

    /**
     * Sets the value of field 'intention'
     * @deprecated
     * Use {@see WrapperHandshakingClientSetProtocol#setClientIntent(Intention) instead}
     * @param value New value for field 'intention'
     */
    @Deprecated
    public void setIntention(Protocol value) {
        if (value == Protocol.LOGIN) {
            this.setClientIntent(Intention.LOGIN_NEXT);
        } else if (value == Protocol.STATUS) {
            this.setClientIntent(Intention.STATUS_NEXT);
        } else {
            throw new IllegalArgumentException("Cannot set intention to " + value.name() + " (Supported: " + Protocol.LOGIN.name() + "," + Protocol.STATUS.name() + ")");
        }
    }

    private StructureModifier<Intention> getIntentions() {
        return this.handle.getModifier().withType(INTENTION_CLASS, INTENTION_CONVERTER);
    }

    /**
     * Sets the value of field 'intention'
     *
     * @param value New value for field 'intention'
     */
    public void setClientIntent(Intention value) {
        this.getIntentions().write(0, value);
    }

}
