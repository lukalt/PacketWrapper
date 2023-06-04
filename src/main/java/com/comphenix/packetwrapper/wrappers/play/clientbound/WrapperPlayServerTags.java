package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.ResourceKey;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.Converters;
import com.comphenix.protocol.wrappers.MinecraftKey;
import it.unimi.dsi.fastutil.ints.IntList;

import java.util.Map;
import java.util.Objects;

public class WrapperPlayServerTags extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.TAGS;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerTags() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerTags(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'tags'
     *
     * @return 'tags'
     */
    public Map<ResourceKey, WrappedNetworkPayload> getTags() {
        return this.handle.getMaps(ResourceKey.CONVERTER, WrappedNetworkPayload.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'tags'
     *
     * @param value New value for field 'tags'
     */
    public void setTags(Map<ResourceKey, WrappedNetworkPayload> value) {
        this.handle.getMaps(ResourceKey.CONVERTER, WrappedNetworkPayload.CONVERTER).write(0, value);
    }

    public static class WrappedNetworkPayload {
        private Map<MinecraftKey, IntList> tags;
        private final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("tags.TagNetworkSerialization$NetworkPayload", "tags.TagNetworkSerialization$a");
        private final static EquivalentConverter<WrappedNetworkPayload> CONVERTER = AutoWrapper.wrap(WrappedNetworkPayload.class, HANDLE_TYPE)
                .field(0, BukkitConverters.getMapConverter(MinecraftKey.getConverter(), Converters.passthrough(IntList.class)));

        public WrappedNetworkPayload(Map<MinecraftKey, IntList> tags) {
            this.tags = tags;
        }

        public WrappedNetworkPayload() {
        }

        public Map<MinecraftKey, IntList> getTags() {
            return tags;
        }

        public void setTags(Map<MinecraftKey, IntList> tags) {
            this.tags = tags;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedNetworkPayload that = (WrappedNetworkPayload) o;

            return Objects.equals(tags, that.tags);
        }

        @Override
        public int hashCode() {
            return tags != null ? tags.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "WrappedNetworkPayload{" +
                    "tags=" + tags +
                    '}';
        }
    }

}
