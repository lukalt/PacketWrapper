package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientSetJigsaw;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 12.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientSetJigsawTest {
    @Test
    public void test() {
        WrapperPlayClientSetJigsaw dummy = new WrapperPlayClientSetJigsaw();
        dummy.setJoint(WrapperPlayClientSetJigsaw.JointType.ALIGNED);
        assertEquals(WrapperPlayClientSetJigsaw.JointType.ALIGNED, dummy.getJoint());
    }
}