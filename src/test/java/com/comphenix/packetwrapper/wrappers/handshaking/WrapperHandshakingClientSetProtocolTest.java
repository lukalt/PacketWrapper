package com.comphenix.packetwrapper.wrappers.handshaking;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.protocol.PacketType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 04.02.2024
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperHandshakingClientSetProtocolTest {

    @SuppressWarnings("deprecation")
    @Test
    void testLegacySetConversion() {
        WrapperHandshakingClientSetProtocol dummy = new WrapperHandshakingClientSetProtocol();
        dummy.setClientIntent(WrapperHandshakingClientSetProtocol.Intention.STATUS_NEXT);
        assertEquals(WrapperHandshakingClientSetProtocol.Intention.STATUS_NEXT, dummy.getClientIntent());
        assertEquals(PacketType.Protocol.STATUS, dummy.getIntention());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testLegacyGetConversion() {
        WrapperHandshakingClientSetProtocol dummy = new WrapperHandshakingClientSetProtocol();
        dummy.setIntention(PacketType.Protocol.STATUS);
        assertEquals(WrapperHandshakingClientSetProtocol.Intention.STATUS_NEXT, dummy.getClientIntent());
        assertEquals(PacketType.Protocol.STATUS, dummy.getIntention());
    }

}