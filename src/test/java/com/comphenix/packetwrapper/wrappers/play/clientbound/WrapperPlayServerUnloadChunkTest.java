package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 04.02.2024
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerUnloadChunkTest {

    @Test
    void testLegacyGet() {
        WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk();
        assertEquals(0, packet.getX());
        assertEquals(0, packet.getZ());
    }

    @Test
    void testLegacyModify() {
        WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk();
        packet.setX(1);
        packet.setZ(3);
        assertEquals(1, packet.getX());
        assertEquals(3, packet.getZ());
    }

    @Test
    void testGet() {
        WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk();
        ChunkCoordIntPair pair = packet.getChunkPos();
        assertEquals(0, pair.getChunkX());
        assertEquals(0, pair.getChunkZ());
    }

    @Test
    void testModify() {
        WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk();
        packet.setChunkPos(new ChunkCoordIntPair(1, 3));
        ChunkCoordIntPair pair = packet.getChunkPos();
        assertEquals(1, pair.getChunkX());
        assertEquals(3, pair.getChunkZ());
    }

}