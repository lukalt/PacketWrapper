package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;

public class WrapperPlayServerUnloadChunk extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.UNLOAD_CHUNK;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerUnloadChunk() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerUnloadChunk(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'x'
     *
     * @return 'x'
     */
    public int getX() {
        return this.handle.getChunkCoordIntPairs().read(0).getChunkX();
    }

    /**
     * Sets the value of field 'x'
     *
     * @param value New value for field 'x'
     */
    public void setX(int value) {
        this.handle.getChunkCoordIntPairs().write(0, new ChunkCoordIntPair(value, this.handle.getChunkCoordIntPairs().read(0).getChunkZ()));
    }

    /**
     * Retrieves the value of field 'z'
     *
     * @return 'z'
     */
    public int getZ() {
        return this.handle.getChunkCoordIntPairs().read(0).getChunkZ();
    }

    /**
     * Sets the value of field 'z'
     *
     * @param value New value for field 'z'
     */
    public void setZ(int value) {
        this.handle.getChunkCoordIntPairs().write(0, new ChunkCoordIntPair(this.handle.getChunkCoordIntPairs().read(0).getChunkX(), value));
    }

    public ChunkCoordIntPair getChunkPos() {
        return this.handle.getChunkCoordIntPairs().read(0);
    }

    public void setChunkPos(ChunkCoordIntPair chunkPos) {
        this.handle.getChunkCoordIntPairs().write(0, chunkPos);
    }
}
