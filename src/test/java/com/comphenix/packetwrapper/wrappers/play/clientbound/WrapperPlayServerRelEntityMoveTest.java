package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Lukas Alt
 * @since 04.06.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerRelEntityMoveTest {
    @Test
    public void test() {
        WrapperPlayServerRelEntityMove dummy = new WrapperPlayServerRelEntityMove();
        dummy.setEntityId(1337);
        dummy.setDeltaX((short) 1);
        dummy.setDeltaY((short) 2);
        dummy.setDeltaZ((short) 3);
        dummy.setOnGround(false);
        assertEquals(1337, dummy.getEntityId());
        assertEquals((short) 1, dummy.getDeltaX());
        assertEquals((short) 2, dummy.getDeltaY());
        assertEquals((short) 3, dummy.getDeltaZ());
        assertFalse(dummy.getOnGround());
    }
}