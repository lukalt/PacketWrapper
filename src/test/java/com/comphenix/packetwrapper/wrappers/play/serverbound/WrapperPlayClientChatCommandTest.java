package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.data.WrappedLastSeenMessagesUpdate;
import com.comphenix.protocol.wrappers.WrappedMessageSignature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Instant;
import java.util.ArrayList;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lukas Alt
 * @since 21.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientChatCommandTest {
    @Test
    public void test() {
        WrapperPlayClientChatCommand dummy = new WrapperPlayClientChatCommand();
        dummy.setCommand("test");
        dummy.setSalt(1337L);
        Instant now = Instant.now();
        dummy.setTimeStamp(now);
        WrapperPlayClientChatCommand.WrappedArgumentSignatures value = new WrapperPlayClientChatCommand.WrappedArgumentSignatures(new ArrayList<>());
        value.getArguments().add(new WrapperPlayClientChatCommand.WrappedArgumentSignature("test", new WrappedMessageSignature(new byte[256])));
        dummy.setArgumentSignatures(value);
        final BitSet acknowledged = new BitSet(5);
        dummy.setLastSeenMessages(new WrappedLastSeenMessagesUpdate(5, acknowledged));
        assertEquals("test", dummy.getCommand());
        assertEquals(1337L, dummy.getSalt());
        assertEquals(now, dummy.getTimeStamp());
        assertEquals("test", dummy.getArgumentSignatures().getArguments().get(0).getName());
        assertEquals(5, dummy.getLastSeenMessages().getOffset());
        assertEquals(acknowledged, dummy.getLastSeenMessages().getAcknowledged());

    }
}