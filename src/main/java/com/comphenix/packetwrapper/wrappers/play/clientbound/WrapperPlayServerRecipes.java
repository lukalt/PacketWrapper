package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.ConstructorAccessor;
import com.comphenix.protocol.reflect.accessors.FieldAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.MinecraftKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WrapperPlayServerRecipes extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.RECIPES;
    private static final Class<?> ACTION_TYPE = MinecraftReflection.getNullableNMS("network.protocol.game.PacketPlayOutRecipes$Action");

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerRecipes() {
        super(TYPE);
    }

    public WrapperPlayServerRecipes(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'state'
     *
     * @return 'state'
     */
    public Action getState() {
        return this.handle.getModifier().withType(ACTION_TYPE, new EnumWrappers.IndexedEnumConverter<>(Action.class, ACTION_TYPE)).read(0);
    }

    /**
     * Sets the value of field 'state'
     *
     * @param value New value for field 'state'
     */
    public void setState(Action value) {
        this.handle.getModifier().withType(ACTION_TYPE, new EnumWrappers.IndexedEnumConverter<>(Action.class, ACTION_TYPE)).write(0, value);
    }

    /**
     * Retrieves the value of field 'recipes'
     *
     * @return 'recipes'
     */
    public List<MinecraftKey> getRecipes() {
        return this.handle.getLists(MinecraftKey.getConverter()).read(0);
    }

    /**
     * Sets the value of field 'recipes'
     *
     * @param value New value for field 'recipes'
     */
    public void setRecipes(List<MinecraftKey> value) {
        this.handle.getLists(MinecraftKey.getConverter()).write(0, value);
    }

    /**
     * Retrieves the value of field 'toHighlight'
     *
     * @return 'toHighlight'
     */
    public List<MinecraftKey> getToHighlight() {
        return this.handle.getLists(MinecraftKey.getConverter()).read(1);
    }

    /**
     * Sets the value of field 'toHighlight'
     *
     * @param value New value for field 'toHighlight'
     */
    public void setToHighlight(List<MinecraftKey> value) {
        this.handle.getLists(MinecraftKey.getConverter()).write(1, value);
    }

    /**
     * Retrieves a wrapped copy of the recipe book settings
     *
     * @return 'bookSettings'
     */
    public WrappedRecipeBookSettings getBookSettings() {
        return this.handle.getModifier().withType(WrappedRecipeBookSettings.HANDLE_TYPE, WrappedRecipeBookSettings.CONVERTER).read(0);
    }

    /**
     * Sets the recipe book settings
     *
     * @param value New value for field 'bookSettings'
     */
    public void setBookSettings(WrappedRecipeBookSettings value) {
        this.handle.getModifier().withType(WrappedRecipeBookSettings.HANDLE_TYPE, WrappedRecipeBookSettings.CONVERTER).write(0, value);
    }

    public enum Action {
        INIT,
        ADD,
        REMOVE;
    }

    public static class WrappedRecipeBookSettings {
        private static final Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("stats.RecipeBookSettings");
        private static final ConstructorAccessor CONSTRUCTOR = Accessors.getConstructorAccessor(HANDLE_TYPE, Map.class);
        private static final FieldAccessor STATES_FIELD = Accessors.getFieldAccessorArray(HANDLE_TYPE, Map.class, true)[1];
        private static final Class<?> ACTION_TYPE = MinecraftReflection.getNullableNMS("world.inventory.RecipeBookType");

        private final Map<RecipeBookType, WrappedTypeSettings> settingsMap;

        public Map<RecipeBookType, WrappedTypeSettings> getSettingsMap() {
            return settingsMap;
        }

        public WrappedRecipeBookSettings() {
            this.settingsMap = new HashMap<>();
        }

        public WrappedRecipeBookSettings(Map<RecipeBookType, WrappedTypeSettings> settingsMap) {
            this.settingsMap = settingsMap;
        }

        public WrappedTypeSettings getSettings(RecipeBookType type) {
            return this.settingsMap.computeIfAbsent(type, a -> new WrappedTypeSettings());
        }

        private static final EquivalentConverter<RecipeBookType> TYPE_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(WrapperPlayServerRecipes.RecipeBookType.class, ACTION_TYPE);
        private static final EquivalentConverter<WrappedRecipeBookSettings> CONVERTER = new EquivalentConverter<>() {
            @Override
            public Object getGeneric(WrappedRecipeBookSettings specific) {
                Map<Object, Object> handle = new HashMap<>();
                for (Map.Entry<RecipeBookType, WrappedTypeSettings> e : specific.getSettingsMap().entrySet()) {
                    Object generic = TYPE_CONVERTER.getGeneric(e.getKey());
                    handle.put(generic, WrappedTypeSettings.CONVERTER.getGeneric(e.getValue()));
                }
                return CONSTRUCTOR.invoke(handle);
            }

            @Override
            public WrappedRecipeBookSettings getSpecific(Object generic) {
                Map<RecipeBookType, WrappedTypeSettings> wrapped = new HashMap<>();
                Map<?, ?> handle = (Map) STATES_FIELD.get(generic);
                for (Map.Entry<?, ?> e : handle.entrySet()) {
                    wrapped.put(TYPE_CONVERTER.getSpecific(e.getKey()), WrappedTypeSettings.CONVERTER.getSpecific(e.getValue()));
                }
                return new WrappedRecipeBookSettings(wrapped);
            }

            @Override
            public Class<WrappedRecipeBookSettings> getSpecificType() {
                return WrappedRecipeBookSettings.class;
            }
        };

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedRecipeBookSettings that = (WrappedRecipeBookSettings) o;

            return Objects.equals(settingsMap, that.settingsMap);
        }

        @Override
        public int hashCode() {
            return settingsMap != null ? settingsMap.hashCode() : 0;
        }
    }

    public static class WrappedTypeSettings {
        private static final Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("stats.RecipeBookSettings$TypeSettings", "stats.RecipeBookSettings$a");
        private static final EquivalentConverter<WrappedTypeSettings> CONVERTER = AutoWrapper.wrap(WrappedTypeSettings.class, HANDLE_TYPE);

        private boolean open;
        private boolean filtering;

        public boolean isOpen() {
            return open;
        }

        public void setOpen(boolean open) {
            this.open = open;
        }

        public boolean isFiltering() {
            return filtering;
        }

        public void setFiltering(boolean filtering) {
            this.filtering = filtering;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedTypeSettings that = (WrappedTypeSettings) o;

            if (open != that.open) return false;
            return filtering == that.filtering;
        }

        @Override
        public int hashCode() {
            int result = (open ? 1 : 0);
            result = 31 * result + (filtering ? 1 : 0);
            return result;
        }
    }

    public enum RecipeBookType {
        CRAFTING,
        FURNACE,
        BLAST_FURNACE,
        SMOKER;
    }

}
