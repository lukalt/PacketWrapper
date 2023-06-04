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
class WrapperPlayServerRelEntityMoveLookTest {

    @Test
    public void test() {
        WrapperPlayServerRelEntityMoveLook dummy = new WrapperPlayServerRelEntityMoveLook();
        dummy.setEntityId(1337);
        dummy.setDeltaX((short) 1);
        dummy.setDeltaY((short) 2);
        dummy.setDeltaZ((short) 3);
        dummy.setYaw(ProtocolConversion.angleToDegrees((byte) 64));
        dummy.setPitch(ProtocolConversion.angleToDegrees((byte) 32));
        dummy.setOnGround(false);
        assertEquals(1337, dummy.getEntityId());
        assertEquals((short) 1, dummy.getDeltaX());
        assertEquals((short) 2, dummy.getDeltaY());
        assertEquals((short) 3, dummy.getDeltaZ());
        assertEquals(ProtocolConversion.angleToDegrees((byte) 64), dummy.getYaw());
        assertEquals(ProtocolConversion.angleToDegrees((byte) 32), dummy.getPitch());
        assertFalse(dummy.getOnGround());
    }

}