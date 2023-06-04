package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.util.ProtocolConversion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 04.06.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerEntityLookTest {
    @Test
    public void test() {
        WrapperPlayServerEntityLook dummy = new WrapperPlayServerEntityLook();
        dummy.setEntityId(1337);
        dummy.setYaw(ProtocolConversion.angleToDegrees((byte) 64));
        dummy.setPitch(ProtocolConversion.angleToDegrees((byte) 32));
        dummy.setOnGround(false);
        assertEquals(1337, dummy.getEntityId());
        assertEquals(ProtocolConversion.angleToDegrees((byte) 64), dummy.getYaw());
        assertEquals(ProtocolConversion.angleToDegrees((byte) 32), dummy.getPitch());
        assertFalse(dummy.getOnGround());
    }

}