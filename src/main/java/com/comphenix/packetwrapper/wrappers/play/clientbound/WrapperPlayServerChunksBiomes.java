package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WrapperPlayServerChunksBiomes extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.CHUNKS_BIOMES;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerChunksBiomes() {
        super(TYPE);
    }

    public WrapperPlayServerChunksBiomes(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'chunkBiomeData'
     *
     * @return 'chunkBiomeData'
     */
    public List<WrappedChunkBiomeData> getChunkBiomeData() {
        return this.handle.getLists(WrappedChunkBiomeData.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'chunkBiomeData'
     *
     * @param value New value for field 'chunkBiomeData'
     */
    public void setChunkBiomeData(List<WrappedChunkBiomeData> value) {
        this.handle.getLists(WrappedChunkBiomeData.CONVERTER).write(0, value);
    }

    public static class WrappedChunkBiomeData {
        private final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundChunksBiomesPacket$ChunkBiomeData", "network.protocol.game.ClientboundChunksBiomesPacket$a");
        final static EquivalentConverter<WrappedChunkBiomeData> CONVERTER = AutoWrapper.wrap(WrappedChunkBiomeData.class, HANDLE_TYPE)
                .field(0, ChunkCoordIntPair.getConverter());

        private ChunkCoordIntPair pos;
        private byte[] buffer;

        public WrappedChunkBiomeData(ChunkCoordIntPair pos, byte[] buffer) {
            this.pos = pos;
            this.buffer = buffer;
        }

        public WrappedChunkBiomeData() {
        }

        public ChunkCoordIntPair getPos() {
            return pos;
        }

        public void setPos(ChunkCoordIntPair pos) {
            this.pos = pos;
        }

        public byte[] getBuffer() {
            return buffer;
        }

        public void setBuffer(byte[] buffer) {
            this.buffer = buffer;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedChunkBiomeData that = (WrappedChunkBiomeData) o;

            if (!Objects.equals(pos, that.pos)) return false;
            return Arrays.equals(buffer, that.buffer);
        }

        @Override
        public int hashCode() {
            int result = pos != null ? pos.hashCode() : 0;
            result = 31 * result + Arrays.hashCode(buffer);
            return result;
        }

        @Override
        public String toString() {
            return "WrappedChunkBiomeData{" +
                    "pos=" + pos +
                    ", buffer=" + Arrays.toString(buffer) +
                    '}';
        }
    }
}
