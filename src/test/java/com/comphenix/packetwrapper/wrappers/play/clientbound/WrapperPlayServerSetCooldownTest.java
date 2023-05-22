package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.clientbound.WrapperPlayServerSetCooldown;
import org.bukkit.Material;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 12.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerSetCooldownTest {

    public static final Material DUMMY_TYPE = Material.BLAST_FURNACE;
    public static final int DUMMY_DURATION = 1337;

    @Test
    public void test() {
        WrapperPlayServerSetCooldown dummy = new WrapperPlayServerSetCooldown();
        dummy.setItem(DUMMY_TYPE);
        dummy.setDuration(DUMMY_DURATION);
        assertEquals(DUMMY_TYPE, dummy.getItem());
        assertEquals(DUMMY_DURATION, dummy.getDuration());
    }
}