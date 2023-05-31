package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 31.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerPlayerListHeaderFooterTest {
    @Test
    public void test() {
        WrapperPlayServerPlayerListHeaderFooter dummy = new WrapperPlayServerPlayerListHeaderFooter();

        WrappedChatComponent header = WrappedChatComponent.fromText("Header");
        WrappedChatComponent footer = WrappedChatComponent.fromText("Footer");
        dummy.setHeader(header);
        dummy.setFooter(footer);
        assertEquals(header, dummy.getHeader());
        assertEquals(footer, dummy.getFooter());
    }
}