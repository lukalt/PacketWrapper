package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import org.bukkit.scoreboard.DisplaySlot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 04.02.2024
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerScoreboardDisplayObjectiveTest {

    public static final int SIDEBAR_INDEX = 2;

    @SuppressWarnings("deprecation")
    @Test
    void testModify() {
        WrapperPlayServerScoreboardDisplayObjective dummy = new WrapperPlayServerScoreboardDisplayObjective();
        dummy.setDisplaySlot(DisplaySlot.SIDEBAR);
        assertEquals(DisplaySlot.SIDEBAR, dummy.getDisplaySlot());
        assertEquals(SIDEBAR_INDEX, dummy.getSlot());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testModifyLegacy() {
        WrapperPlayServerScoreboardDisplayObjective dummy = new WrapperPlayServerScoreboardDisplayObjective();
        dummy.setSlot(SIDEBAR_INDEX);
        assertEquals(DisplaySlot.SIDEBAR, dummy.getDisplaySlot());
        assertEquals(SIDEBAR_INDEX, dummy.getSlot());
    }
}