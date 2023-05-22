package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientRecipeSettings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 12.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientRecipeSettingsTest {

    @Test
    public void test() {
        WrapperPlayClientRecipeSettings dummy = new WrapperPlayClientRecipeSettings();
        dummy.setBookType(WrapperPlayClientRecipeSettings.RecipeBookType.BLAST_FURNACE);
        dummy.setIsFiltering(true);
        dummy.setIsOpen(false);
        assertEquals(WrapperPlayClientRecipeSettings.RecipeBookType.BLAST_FURNACE, dummy.getBookType());
        assertTrue(dummy.getIsFiltering());
        assertFalse(dummy.getIsOpen());
    }

}