package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedStatistic;

import java.util.Map;

/**
 * Sent as a response to @link{{@link com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientClientCommand}}. Will only send the changed values if previously requested.
 */
public class WrapperPlayServerStatistic extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.STATISTIC;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerStatistic() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerStatistic(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'stats'
     *
     * @return 'stats'
     */
    public Map<WrappedStatistic, Integer> getStats() {
        return this.handle.getStatisticMaps().read(0);
    }

    /**
     * Sets the value of field 'stats'
     *
     * @param value New value for field 'stats'
     */
    public void setStats(Map<WrappedStatistic, Integer> value) {
        this.handle.getStatisticMaps().write(0, value);
    }

}
