package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientSetCommandBlock;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 12.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientSetCommandBlockTest {

    @Test
    public void test() {
        WrapperPlayClientSetCommandBlock dummy = new WrapperPlayClientSetCommandBlock();
        dummy.setMode(WrapperPlayClientSetCommandBlock.CommandBlockMode.AUTO);
        dummy.setMode(WrapperPlayClientSetCommandBlock.CommandBlockMode.SEQUENCE);

        dummy.setCommand("/test");
        dummy.setAutomatic(false);
        dummy.setPos(new BlockPosition(1, 2, 3));
        dummy.setConditional(false);
        dummy.setTrackOutput(true);
        assertNotEquals(WrapperPlayClientSetCommandBlock.CommandBlockMode.AUTO, dummy.getMode());
        assertEquals(WrapperPlayClientSetCommandBlock.CommandBlockMode.SEQUENCE, dummy.getMode());
        assertEquals("/test", dummy.getCommand());
        assertFalse(dummy.getAutomatic());
        assertEquals(new BlockPosition(1, 2, 3), dummy.getPos());
        assertFalse(dummy.getConditional());
        assertTrue(dummy.getTrackOutput());
    }
}