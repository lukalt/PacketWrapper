package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.FuzzyReflection;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.ConstructorAccessor;
import com.comphenix.protocol.reflect.accessors.MethodAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import org.bukkit.craftbukkit.v1_19_R3.inventory.*;
import org.bukkit.craftbukkit.v1_19_R3.util.CraftNamespacedKey;
import org.bukkit.inventory.*;

import java.util.List;

public class WrapperPlayServerRecipeUpdate extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.RECIPE_UPDATE;

    public WrapperPlayServerRecipeUpdate() {
        super(TYPE);
    }

    public WrapperPlayServerRecipeUpdate(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'recipes'
     *
     * @return 'recipes'
     */
    public List<Recipe> getRecipes() {
        return this.handle.getLists(RECIPE_CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'recipes'
     *
     * @param value New value for field 'recipes'
     */
    public void setRecipes(List<Recipe> value) {
        this.handle.getLists(RECIPE_CONVERTER).write(0, value);
    }

    static final EquivalentConverter<Recipe> RECIPE_CONVERTER = new EquivalentConverter<>() {
        private final static Class<?> NMS_RECIPE = MinecraftReflection.getMinecraftClass("world.item.crafting.Recipe", "world.item.crafting.IRecipe");
        private final static MethodAccessor TO_BUKKIT = Accessors.getMethodAccessor(NMS_RECIPE, "toBukkitRecipe");

        private static MethodAccessor createFromBukkitRecipeAccessor(String name) {
            return Accessors.getMethodAccessor(FuzzyReflection.fromClass(MinecraftReflection.getCraftBukkitClass("inventory." + name), false).getMethodByName("fromBukkitRecipe"));
        }
        private final static MethodAccessor FROM_BUKKIT_SHAPED = createFromBukkitRecipeAccessor("CraftShapedRecipe");
        private final static MethodAccessor FROM_BUKKIT_SHAPELESS = createFromBukkitRecipeAccessor("CraftShapelessRecipe");
        private final static MethodAccessor FROM_BUKKIT_FURNACE = createFromBukkitRecipeAccessor("CraftFurnaceRecipe");
        private final static MethodAccessor FROM_BUKKIT_BLASTING = createFromBukkitRecipeAccessor("CraftBlastingRecipe");
        private final static MethodAccessor FROM_BUKKIT_CAMPFIRE = createFromBukkitRecipeAccessor("CraftCampfireRecipe");
        private final static MethodAccessor FROM_BUKKIT_SMOKING = createFromBukkitRecipeAccessor("CraftSmokingRecipe");
        private final static MethodAccessor FROM_BUKKIT_STONE_CUTTING = createFromBukkitRecipeAccessor("CraftStonecuttingRecipe");
        private final static MethodAccessor FROM_BUKKIT_SMITHING = createFromBukkitRecipeAccessor("CraftSmithingRecipe");

        private final static Class<?> BLASTING_RECIPE_CLASS = MinecraftReflection.getMinecraftClass("world.item.crafting.BlastingRecipe", "world.item.crafting.RecipeBlasting");
        private final static ConstructorAccessor BLASTING_RECIPE_CONSTRUCTOR = Accessors.getConstructorAccessor(FuzzyReflection.fromClass(BLASTING_RECIPE_CLASS, true).getConstructors().iterator().next());


        @Override
        public Object getGeneric(Recipe recipe) {
            Recipe craftRecipe = (Recipe) toCraftRecipe(recipe);

            throw new UnsupportedOperationException("Not implemented yet.");
        }

        private Object toCraftRecipe(Recipe recipe) {
            if (recipe instanceof ShapedRecipe) {
                return FROM_BUKKIT_SHAPED.invoke(null, recipe);
            } else if (recipe instanceof ShapelessRecipe) {
                return FROM_BUKKIT_SHAPELESS.invoke(null, recipe);
            } else if (recipe instanceof FurnaceRecipe) {
                return FROM_BUKKIT_FURNACE.invoke(null, recipe);
            } else if (recipe instanceof BlastingRecipe) {
                return FROM_BUKKIT_BLASTING.invoke(null, recipe);
            } else if (recipe instanceof CampfireRecipe) {
                return FROM_BUKKIT_CAMPFIRE.invoke(null, recipe);
            } else if (recipe instanceof SmokingRecipe) {
                return FROM_BUKKIT_SMOKING.invoke(null, recipe);
            } else if (recipe instanceof StonecuttingRecipe) {
                return FROM_BUKKIT_STONE_CUTTING.invoke(null, recipe);
            } else if (recipe instanceof SmithingRecipe) {
                return FROM_BUKKIT_SMITHING.invoke(null, recipe);
            } else if (recipe instanceof ComplexRecipe) {
                throw new UnsupportedOperationException("Cannot add custom complex recipe");
            }
            return null;
        }

        @Override
        public Recipe getSpecific(Object generic) {
            return (Recipe) TO_BUKKIT.invoke(generic);
        }

        @Override
        public Class<Recipe> getSpecificType() {
            return Recipe.class;
        }
    };

}
