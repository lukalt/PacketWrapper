package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientAdvancements;
import com.comphenix.protocol.wrappers.MinecraftKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lukas Alt
 * @since 08.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientAdvancementsTest {

    @Test
    public void test() {
        WrapperPlayClientAdvancements packet = new WrapperPlayClientAdvancements();
        packet.setAction(WrapperPlayClientAdvancements.Action.OPENED_TAB);
        assertEquals(WrapperPlayClientAdvancements.Action.OPENED_TAB, packet.getAction());
        packet.setAction(WrapperPlayClientAdvancements.Action.CLOSED_SCREEN);
        assertEquals(WrapperPlayClientAdvancements.Action.CLOSED_SCREEN, packet.getAction());
        packet.setTab(new MinecraftKey("a", "b"));

    }

}