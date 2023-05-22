package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 21.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientUseEntityTest {
    @Test
    public void test() {
        WrapperPlayClientUseEntity dummy = new WrapperPlayClientUseEntity();
        dummy.setAction(WrappedEnumEntityUseAction.attack());
        assertEquals(EnumWrappers.EntityUseAction.ATTACK, dummy.getAction().getAction());
        dummy.setAction(WrappedEnumEntityUseAction.interact(EnumWrappers.Hand.MAIN_HAND));
        assertEquals(EnumWrappers.EntityUseAction.INTERACT, dummy.getAction().getAction());
        assertEquals(EnumWrappers.Hand.MAIN_HAND, dummy.getAction().getHand());
        dummy.setAction(WrappedEnumEntityUseAction.interactAt(EnumWrappers.Hand.MAIN_HAND, new Vector(1,2,3)));
        assertEquals(EnumWrappers.EntityUseAction.INTERACT_AT, dummy.getAction().getAction());
        assertEquals(EnumWrappers.Hand.MAIN_HAND, dummy.getAction().getHand());
        assertEquals(new Vector(1,2,3), dummy.getAction().getPosition());
    }
}