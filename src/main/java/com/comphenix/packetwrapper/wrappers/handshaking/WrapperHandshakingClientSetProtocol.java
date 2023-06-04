package com.comphenix.packetwrapper.wrappers.handshaking;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Protocol;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperHandshakingClientSetProtocol extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Handshake.Client.SET_PROTOCOL;

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
     *
     * @return 'intention'
     */
    public Protocol getIntention() {
        return this.handle.getProtocols().read(0);
    }

    /**
     * Sets the value of field 'intention'
     *
     * @param value New value for field 'intention'
     */
    public void setIntention(Protocol value) {
        this.handle.getProtocols().write(0, value);
    }

}
