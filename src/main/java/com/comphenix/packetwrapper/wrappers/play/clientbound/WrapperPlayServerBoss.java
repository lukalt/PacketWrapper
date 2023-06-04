package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.FuzzyReflection;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.ConstructorAccessor;
import com.comphenix.protocol.reflect.accessors.FieldAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.UUID;

/**
 * Sent by server to client to control boss bars.
 */
public class WrapperPlayServerBoss extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.BOSS;

    private static final Class<?> BAR_COLOR_CLASS = MinecraftReflection.getMinecraftClass("world.BossEvent$BossBarColor", "world.BossBattle$BarColor");
    private static final Class<?> BAR_STYLE_CLASS = MinecraftReflection.getMinecraftClass("world.BossEvent$BossBarOverlay", "world.BossBattle$BarStyle");
    private static final EquivalentConverter<BarColor> BAR_COLOR_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(BarColor.class, BAR_COLOR_CLASS);
    private static final EquivalentConverter<BarStyle> BAR_STYLE_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(BarStyle.class, BAR_STYLE_CLASS);
    private final static Class<?> PACKET_CLASS = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket", "network.protocol.game.PacketPlayOutBoss");

    private static final EquivalentConverter<WrappedBossBarOperation> OPERATION_CONVERTER = new EquivalentConverter<>() {
        @Override
        public Object getGeneric(WrappedBossBarOperation wrappedBossBarOperation) {
            return switch (wrappedBossBarOperation.getType()) {
                case UPDATE_PROPERTIES ->
                        WrappedBossBarUpdatePropertiesOperation.CONVERTER.getGeneric((WrappedBossBarUpdatePropertiesOperation) wrappedBossBarOperation);
                case UPDATE_PROGRESS ->
                        WrappedBossBarProgressOperation.CONVERTER.getGeneric((WrappedBossBarProgressOperation) wrappedBossBarOperation);
                case ADD ->
                        WrappedBossBarAddOperation.CONVERTER.getGeneric((WrappedBossBarAddOperation) wrappedBossBarOperation);
                case REMOVE -> WrappedBossBarRemoveOperation.HANDLE_ACCESSOR.get(null);
                case UPDATE_NAME ->
                        WrappedBossBarUpdateNameOperation.CONVERTER.getGeneric((WrappedBossBarUpdateNameOperation) wrappedBossBarOperation);
                case UPDATE_STYLE ->
                        WrappedBossBarUpdateStyleOperation.CONVERTER.getGeneric((WrappedBossBarUpdateStyleOperation) wrappedBossBarOperation);
            };
        }

        @Override
        public WrappedBossBarOperation getSpecific(Object o) {
            if (o.getClass().equals(WrappedBossBarUpdatePropertiesOperation.TYPE)) {
                return WrappedBossBarUpdatePropertiesOperation.CONVERTER.getSpecific(o);
            } else if (o.getClass().equals(WrappedBossBarProgressOperation.TYPE)) {
                return WrappedBossBarProgressOperation.CONVERTER.getSpecific(o);
            } else if (o.getClass().equals(WrappedBossBarAddOperation.TYPE)) {
                return WrappedBossBarAddOperation.CONVERTER.getSpecific(o);
            } else if (o.getClass().equals(WrappedBossBarUpdateNameOperation.TYPE)) {
                return WrappedBossBarUpdateNameOperation.CONVERTER.getSpecific(o);
            } else if (o.getClass().equals(WrappedBossBarUpdateStyleOperation.TYPE)) {
                return WrappedBossBarUpdateStyleOperation.CONVERTER.getSpecific(o);
            }
            return new WrappedBossBarRemoveOperation();
        }

        @Override
        public Class<WrappedBossBarOperation> getSpecificType() {
            return WrappedBossBarOperation.class;
        }
    };


    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerBoss() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerBoss(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the unique id of this bar
     *
     * @return 'id'
     */
    public UUID getId() {
        return this.handle.getUUIDs().read(0);
    }

    /**
     * Sets the unique id of this bar
     *
     * @param value New value for field 'id'
     */
    public void setId(UUID value) {
        this.handle.getUUIDs().write(0, value);
    }

    /**
     * Retrieves the current operation. The operation is a mutable copy of the underlying operation. Thus,
     * any changes to it need to be explicitly written back using {@see setOperation}.
     * The operation can be casted to any of specific operation types (e.g. {@see com.comphenix.packetwrapper.wrappers.play.clientbound.WrapperPlayServerBoss.WrappedBossBarAddOperation}) based
     * on its type ({@see WrappedBossBarOperation#getType()}).
     *
     * @return mutable copy as a wrapper for the operation
     */
    public WrappedBossBarOperation getOperation() {
        return this.handle.getModifier().withType(WrappedBossBarOperation.HANDLE_TYPE, OPERATION_CONVERTER).read(0);
    }

    /**
     * Sets the operation of this packet. Can be any of the following operation types:
     *
     * @param value New value for field 'operation'
     * @see WrapperPlayServerBoss.WrappedBossBarAddOperation#create(WrappedChatComponent, float, BarColor, BarStyle, boolean, boolean, boolean)
     * @see WrapperPlayServerBoss.WrappedBossBarRemoveOperation#create()
     * @see WrapperPlayServerBoss.WrappedBossBarProgressOperation#create(float)
     * @see WrapperPlayServerBoss.WrappedBossBarUpdatePropertiesOperation#create(boolean, boolean, boolean)
     * @see WrapperPlayServerBoss.WrappedBossBarUpdateStyleOperation#create(BarColor, BarStyle)
     * @see WrapperPlayServerBoss.WrappedBossBarUpdateNameOperation#create(WrappedChatComponent)
     */
    public void setOperation(WrappedBossBarOperation value) {
        this.handle.getModifier().withType(WrappedBossBarOperation.HANDLE_TYPE, OPERATION_CONVERTER).write(0, value);
    }

    /**
     * Wraps an abstract boss bar operation
     */
    public interface WrappedBossBarOperation {
        Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket$Operation", "network.protocol.game.PacketPlayOutBoss$Action");

        OperationType getType();
    }

    public enum OperationType {
        ADD,
        REMOVE,
        UPDATE_PROGRESS,
        UPDATE_NAME,
        UPDATE_STYLE,
        UPDATE_PROPERTIES
    }

    /**
     * Wrapped for operation to create a new boss bar
     */
    public static class WrappedBossBarAddOperation implements WrappedBossBarOperation {
        private final static Class<?> TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket$AddOperation", "network.protocol.game.PacketPlayOutBoss$a");
        private static final Class<?> BOSS_EVENT_CLASS = MinecraftReflection.getMinecraftClass("server.level.ServerBossEvent", "server.level.BossBattleServer");
        private final static ConstructorAccessor CONSTRUCTOR = Accessors.getConstructorAccessor(TYPE, BOSS_EVENT_CLASS.getSuperclass());

        private final static EquivalentConverter<WrappedBossBarAddOperation> AUTO_WRAPPER = AutoWrapper.wrap(WrappedBossBarAddOperation.class, WrappedBossBarAddOperation.TYPE)
                .field(0, BukkitConverters.getWrappedChatComponentConverter())
                .field(2, BAR_COLOR_CONVERTER)
                .field(3, BAR_STYLE_CONVERTER);

        private final static EquivalentConverter<WrappedBossBarAddOperation> CONVERTER = new EquivalentConverter<>() {
            private static final ConstructorAccessor BOSS_EVENT_CONSTRUCTOR = Accessors.getConstructorAccessor(BOSS_EVENT_CLASS,
                    MinecraftReflection.getIChatBaseComponentClass(),
                    BAR_COLOR_CLASS, BAR_STYLE_CLASS);
            private static final FieldAccessor PROGRESS_FIELD = Accessors.getFieldAccessor(BOSS_EVENT_CLASS.getSuperclass(), float.class, true);
            private static final FieldAccessor[] PROPERTY_ACCESSORS = Accessors.getFieldAccessorArray(BOSS_EVENT_CLASS.getSuperclass(), boolean.class, true);

            @Override
            public Object getGeneric(WrappedBossBarAddOperation specific) {
                // we cannot use an AutoWrapper here
                Object handle = BOSS_EVENT_CONSTRUCTOR.invoke(BukkitConverters.getWrappedChatComponentConverter().getGeneric(specific.name),
                        BAR_COLOR_CONVERTER.getGeneric(specific.color),
                        BAR_STYLE_CONVERTER.getGeneric(specific.overlay));
                PROGRESS_FIELD.set(handle, specific.progress);
                PROPERTY_ACCESSORS[0].set(handle, specific.darkenScreen);
                PROPERTY_ACCESSORS[1].set(handle, specific.playMusic);
                PROPERTY_ACCESSORS[2].set(handle, specific.createWorldFog);
                return CONSTRUCTOR.invoke(handle);
            }

            @Override
            public WrappedBossBarAddOperation getSpecific(Object generic) {
                return AUTO_WRAPPER.getSpecific(generic);
            }

            @Override
            public Class<WrappedBossBarAddOperation> getSpecificType() {
                return WrappedBossBarAddOperation.class;
            }
        };

        public static WrappedBossBarAddOperation create(WrappedChatComponent name, float progress, BarColor color, BarStyle overlay, boolean darkenScreen, boolean playMusic, boolean createWorldFog) {
            WrappedBossBarAddOperation o = new WrappedBossBarAddOperation();
            o.setName(name);
            o.setProgress(progress);
            o.setColor(color);
            o.setOverlay(overlay);
            o.setDarkenScreen(darkenScreen);
            o.setPlayMusic(playMusic);
            o.setCreateWorldFog(createWorldFog);
            return o;
        }

        private WrappedChatComponent name;
        private float progress;
        private BarColor color;
        private BarStyle overlay;
        private boolean darkenScreen;
        private boolean playMusic;
        private boolean createWorldFog;

        /**
         * Gets the text of the boss bar
         *
         * @return text of boss bar
         */
        public WrappedChatComponent getName() {
            return name;
        }

        /**
         * Sets the text of the boss bar
         *
         * @param name new boss bar text
         */
        public void setName(WrappedChatComponent name) {
            this.name = name;
        }

        /**
         * Gets the progress/health of the boss bar
         *
         * @return progress in range between 0.0 and 1.0 inclusive
         */
        public float getProgress() {
            return progress;
        }

        /**
         * Sets the progress/health of the boss bar
         *
         * @param progress progress in range between 0.0 and 1.0 inclusive
         */
        public void setProgress(float progress) {
            this.progress = progress;
        }

        /**
         * Gets the color of the boss bar
         *
         * @return color of boss bar
         */
        public BarColor getColor() {
            return color;
        }

        /**
         * Sets the color of the boss bar
         *
         * @param color new color
         */
        public void setColor(BarColor color) {
            this.color = color;
        }

        /**
         * Gets the overlay type
         *
         * @return overlay type
         */
        public BarStyle getOverlay() {
            return overlay;
        }

        public void setOverlay(BarStyle overlay) {
            this.overlay = overlay;
        }

        public boolean isDarkenScreen() {
            return darkenScreen;
        }

        public void setDarkenScreen(boolean darkenScreen) {
            this.darkenScreen = darkenScreen;
        }

        public boolean isPlayMusic() {
            return playMusic;
        }

        public void setPlayMusic(boolean playMusic) {
            this.playMusic = playMusic;
        }

        public boolean isCreateWorldFog() {
            return createWorldFog;
        }

        public void setCreateWorldFog(boolean createWorldFog) {
            this.createWorldFog = createWorldFog;
        }

        @Override
        public OperationType getType() {
            return OperationType.ADD;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedBossBarAddOperation that = (WrappedBossBarAddOperation) o;

            if (Float.compare(that.progress, progress) != 0) return false;
            if (darkenScreen != that.darkenScreen) return false;
            if (playMusic != that.playMusic) return false;
            if (createWorldFog != that.createWorldFog) return false;
            if (!Objects.equals(name, that.name)) return false;
            if (color != that.color) return false;
            return overlay == that.overlay;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (progress != +0.0f ? Float.floatToIntBits(progress) : 0);
            result = 31 * result + (color != null ? color.hashCode() : 0);
            result = 31 * result + (overlay != null ? overlay.hashCode() : 0);
            result = 31 * result + (darkenScreen ? 1 : 0);
            result = 31 * result + (playMusic ? 1 : 0);
            result = 31 * result + (createWorldFog ? 1 : 0);
            return result;
        }
    }

    /**
     * Operation to remove the boss bar on client side
     */
    public static class WrappedBossBarRemoveOperation implements WrappedBossBarOperation {
        private static final FieldAccessor HANDLE_ACCESSOR = Accessors.getFieldAccessor(FuzzyReflection.fromClass(PACKET_CLASS, true).getFieldListByType(WrappedBossBarOperation.HANDLE_TYPE).stream().filter(f -> Modifier.isStatic(f.getModifiers())).findFirst().orElseThrow());

        public static WrappedBossBarRemoveOperation create() {
            return new WrappedBossBarRemoveOperation();
        }

        @Override
        public OperationType getType() {
            return OperationType.REMOVE;
        }

    }

    /**
     * Operation to update the boss bar name on client side
     */
    public static class WrappedBossBarUpdateNameOperation implements WrappedBossBarOperation {
        private final static Class<?> TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket$UpdateNameOperation", "network.protocol.game.PacketPlayOutBoss$e");
        private final static EquivalentConverter<WrappedBossBarUpdateNameOperation> CONVERTER = AutoWrapper.wrap(WrappedBossBarUpdateNameOperation.class, TYPE)
                .field(0, BukkitConverters.getWrappedChatComponentConverter());
        private WrappedChatComponent name;

        public static WrappedBossBarUpdateNameOperation create(WrappedChatComponent component) {
            WrappedBossBarUpdateNameOperation o = new WrappedBossBarUpdateNameOperation();
            o.setName(component);
            return o;
        }

        public WrappedChatComponent getName() {
            return name;
        }

        public void setName(WrappedChatComponent name) {
            this.name = name;
        }

        @Override
        public OperationType getType() {
            return OperationType.UPDATE_NAME;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedBossBarUpdateNameOperation that = (WrappedBossBarUpdateNameOperation) o;

            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    /**
     * Operation to update the progress of the boss bar on client side
     */
    public static class WrappedBossBarProgressOperation implements WrappedBossBarOperation {
        private final static Class<?> TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket$ProgressOperation", "network.protocol.game.PacketPlayOutBoss$f");
        private final static EquivalentConverter<WrappedBossBarProgressOperation> CONVERTER = AutoWrapper.wrap(WrappedBossBarProgressOperation.class, TYPE);
        private float progress;

        public static WrappedBossBarProgressOperation create(float progress) {
            WrappedBossBarProgressOperation o = new WrappedBossBarProgressOperation();
            o.setProgress(progress);
            return o;
        }

        /**
         * Gets the progress
         *
         * @return progress ranged 0.0 to 1.0 inclusive
         */
        public float getProgress() {
            return progress;
        }

        /**
         * Sets the progress
         *
         * @param progress ranged 0.0 to 1.0 inclusive
         */
        public void setProgress(float progress) {
            this.progress = progress;
        }

        @Override
        public OperationType getType() {
            return OperationType.UPDATE_PROGRESS;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedBossBarProgressOperation that = (WrappedBossBarProgressOperation) o;

            return Float.compare(that.progress, progress) == 0;
        }

        @Override
        public int hashCode() {
            return (progress != +0.0f ? Float.floatToIntBits(progress) : 0);
        }
    }

    /**
     * Operation to update flags of the boss bar
     */
    public static class WrappedBossBarUpdatePropertiesOperation implements WrappedBossBarOperation {
        private final static Class<?> TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket$UpdatePropertiesOperation", "network.protocol.game.PacketPlayOutBoss$g");
        private final static EquivalentConverter<WrappedBossBarUpdatePropertiesOperation> CONVERTER = AutoWrapper.wrap(WrappedBossBarUpdatePropertiesOperation.class, TYPE);
        private boolean darkenScreen;
        private boolean playMusic;
        private boolean createWorldFog;

        public static WrappedBossBarUpdatePropertiesOperation create(boolean darkenScreen, boolean playMusic, boolean createWorldFog) {
            WrappedBossBarUpdatePropertiesOperation o = new WrappedBossBarUpdatePropertiesOperation();
            o.setDarkenScreen(darkenScreen);
            o.setPlayMusic(playMusic);
            o.setCreateWorldFog(createWorldFog);
            return o;
        }

        public boolean isDarkenScreen() {
            return darkenScreen;
        }

        public void setDarkenScreen(boolean darkenScreen) {
            this.darkenScreen = darkenScreen;
        }

        public boolean isPlayMusic() {
            return playMusic;
        }

        public void setPlayMusic(boolean playMusic) {
            this.playMusic = playMusic;
        }

        public boolean isCreateWorldFog() {
            return createWorldFog;
        }

        public void setCreateWorldFog(boolean createWorldFog) {
            this.createWorldFog = createWorldFog;
        }

        @Override
        public OperationType getType() {
            return OperationType.UPDATE_PROPERTIES;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedBossBarUpdatePropertiesOperation that = (WrappedBossBarUpdatePropertiesOperation) o;

            if (darkenScreen != that.darkenScreen) return false;
            if (playMusic != that.playMusic) return false;
            return createWorldFog == that.createWorldFog;
        }

        @Override
        public int hashCode() {
            int result = (darkenScreen ? 1 : 0);
            result = 31 * result + (playMusic ? 1 : 0);
            result = 31 * result + (createWorldFog ? 1 : 0);
            return result;
        }
    }

    /**
     * Option to update the style of the boss bar
     */
    public static class WrappedBossBarUpdateStyleOperation implements WrappedBossBarOperation {
        private final static Class<?> TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundBossEventPacket$UpdateStyleOperation", "network.protocol.game.PacketPlayOutBoss$h");

        private final static EquivalentConverter<WrappedBossBarUpdateStyleOperation> CONVERTER = AutoWrapper.wrap(WrappedBossBarUpdateStyleOperation.class, TYPE)
                .field(0, BAR_COLOR_CONVERTER)
                .field(1, BAR_STYLE_CONVERTER);

        public static WrappedBossBarUpdateStyleOperation create(BarColor color, BarStyle style) {
            WrappedBossBarUpdateStyleOperation o = new WrappedBossBarUpdateStyleOperation();
            o.setColor(color);
            o.setOverlay(style);
            return o;
        }

        private BarColor color;
        private BarStyle overlay;

        public BarColor getColor() {
            return this.color;
        }

        public void setColor(BarColor color) {
            this.color = color;
        }

        public BarStyle getOverlay() {
            return overlay;
        }

        public void setOverlay(BarStyle overlay) {
            this.overlay = overlay;
        }

        @Override
        public OperationType getType() {
            return OperationType.UPDATE_STYLE;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedBossBarUpdateStyleOperation that = (WrappedBossBarUpdateStyleOperation) o;

            if (color != that.color) return false;
            return overlay == that.overlay;
        }

        @Override
        public int hashCode() {
            int result = color.hashCode();
            result = 31 * result + overlay.hashCode();
            return result;
        }
    }

}
