package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 18.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerRecipeUpdateTest {
    @Test
    public void test() {
        (WrapperPlayServerRecipeUpdate dummy = new WrapperPlayServerRecipeUpdate();
        List<Recipe> value = List.of(new ShapedRecipe(NamespacedKey.minecraft("wooden_axe"), new ItemStack(Material.WOODEN_AXE)).shape("aa0","ab0","0b0").setIngredient('a', Material.OAK_WOOD).setIngredient('b', Material.STICK));
        dummy.setRecipes(value);
        assertEquals(value, dummy.getRecipes());

    }

    @Test
    public void testRecipeConverter() {
       /* Bukkit.getServer().recipeIterator().forEachRemaining(recipe -> {
            assertEquals(recipe, Utils.unwrapAndWarp(recipe, WrapperPlayServerRecipeUpdate.RECIPE_CONVERTER), "Failed recipe converter for " + recipe);
        });*/
    }
}