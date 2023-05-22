package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import org.bukkit.potion.PotionEffectType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 17.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerEntityEffectTest {
    @Test
    public void test() {
        WrapperPlayServerEntityEffect dummy = new WrapperPlayServerEntityEffect();
        dummy.setEntityId(1);
        dummy.setEffectAmplifier((byte) 2);
        dummy.setFlags((byte) (0x1 | 0x8));
        dummy.setEffectDurationTicks(1337);
        dummy.setEffect(PotionEffectType.ABSORPTION);
        dummy.setFactorData(null);
        assertNull(dummy.getFactorData());
        WrapperPlayServerEntityEffect.WrappedFactorData factorData = new WrapperPlayServerEntityEffect.WrappedFactorData();
        factorData.setFactorStart(1.3F);
        factorData.setHadEffectLastTick(true);
        factorData.setFactorPreviousFrame(3);
        dummy.setFactorData(factorData);
        assertEquals(factorData, dummy.getFactorData());
        assertEquals(PotionEffectType.ABSORPTION, dummy.getEffect());

        dummy.setFlags((byte) (WrapperPlayServerEntityEffect.FLAG_SHOW_PARTICLE | WrapperPlayServerEntityEffect.FLAG_AMBIENT | WrapperPlayServerEntityEffect.FLAG_SHOW_ICON));
        assertTrue(dummy.isAmbient());
        assertTrue(dummy.isShowIcon());
        assertTrue(dummy.isShowParticles());
        dummy.setAmbient(false);
        assertEquals((byte) (WrapperPlayServerEntityEffect.FLAG_SHOW_PARTICLE | WrapperPlayServerEntityEffect.FLAG_SHOW_ICON), dummy.getFlags());
        dummy.setShowIcon(false);
        dummy.setShowParticles(false);
        assertEquals((byte) 0, dummy.getFlags());

    }
}