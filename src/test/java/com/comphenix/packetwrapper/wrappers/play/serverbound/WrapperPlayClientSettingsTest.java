package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientSettings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 12.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientSettingsTest {
    @Test
    public void test() {
        WrapperPlayClientSettings dummy = new WrapperPlayClientSettings();
        dummy.setMainHand(WrapperPlayClientSettings.HumanoidArm.LEFT);
        dummy.setMainHand(WrapperPlayClientSettings.HumanoidArm.RIGHT);
        assertEquals(WrapperPlayClientSettings.HumanoidArm.RIGHT, dummy.getMainHand());
    }

}