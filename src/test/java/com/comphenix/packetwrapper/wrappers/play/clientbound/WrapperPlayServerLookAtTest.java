package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 17.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerLookAtTest {
    @Test
    public void test() {
        WrapperPlayServerLookAt dummy = new WrapperPlayServerLookAt();
        dummy.setFromAnchor(WrapperPlayServerLookAt.Anchor.EYES);
        dummy.setToAnchor(WrapperPlayServerLookAt.Anchor.FEET);
        assertEquals(WrapperPlayServerLookAt.Anchor.EYES, dummy.getFromAnchor());
        assertEquals(WrapperPlayServerLookAt.Anchor.FEET, dummy.getToAnchor());
    }
}