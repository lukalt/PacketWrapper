package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.*;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WrapperPlayServerMap extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.MAP;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerMap() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerMap(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'mapId'
     *
     * @return 'mapId'
     */
    public int getMapId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'mapId'
     *
     * @param value New value for field 'mapId'
     */
    public void setMapId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'scale'
     *
     * @return 'scale'
     */
    public byte getScale() {
        return this.handle.getBytes().read(0);
    }

    /**
     * Sets the value of field 'scale'
     *
     * @param value New value for field 'scale'
     */
    public void setScale(byte value) {
        this.handle.getBytes().write(0, value);
    }

    /**
     * Retrieves the value of field 'locked'
     *
     * @return 'locked'
     */
    public boolean getLocked() {
        return this.handle.getBooleans().read(0);
    }

    /**
     * Sets the value of field 'locked'
     *
     * @param value New value for field 'locked'
     */
    public void setLocked(boolean value) {
        this.handle.getBooleans().write(0, value);
    }

    /**
     * Retrieves the value of field 'decorations'
     *
     * @return 'decorations'
     */
    @Nullable
    public List<WrappedMapDecoration> getDecorations() {
        return this.handle.getLists(WrappedMapDecoration.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'decorations'
     *
     * @param value New value for field 'decorations'
     */
    public void setDecorations(@Nullable List<WrappedMapDecoration> value) {
        this.handle.getLists(WrappedMapDecoration.CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'colorPatch'
     *
     * @return 'colorPatch'
     * @link getColorPatch
     */
    @Deprecated
    public InternalStructure getColorPatchInternal() {
        return this.handle.getStructures().read(1);
    }

    /**
     * Sets the value of field 'colorPatch'
     *
     * @param value New value for field 'colorPatch'
     * @link setColorPatch
     */
    @Deprecated
    public void setColorPatchInternal(InternalStructure value) {
        this.handle.getStructures().write(1, value);
    }

    /**
     * Retrieves the value of field 'colorPatch'
     *
     * @return 'colorPatch'
     */
    @Nullable
    public WrappedMapPatch getColorPatch() {
        return this.handle.getModifier().withType(WrappedMapPatch.HANDLE_TYPE, WrappedMapPatch.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'colorPatch'
     *
     * @param value New value for field 'colorPatch'
     */
    public void setColorPatch(@Nullable WrappedMapPatch value) {
        this.handle.getModifier().withType(WrappedMapPatch.HANDLE_TYPE, WrappedMapPatch.CONVERTER).write(0, value);
    }

    public static class WrappedMapPatch {
        private static final Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("world.level.saveddata.maps.WorldMap$b");
        private static final EquivalentConverter<WrappedMapPatch> CONVERTER = Converters.ignoreNull(AutoWrapper.wrap(WrappedMapPatch.class, HANDLE_TYPE));
        private int startX;
        private int startY;
        private int width;
        private int height;
        private byte[] mapColors;

        public WrappedMapPatch(int startX, int startY, int width, int height, byte[] mapColors) {
            this.startX = startX;
            this.startY = startY;
            this.width = width;
            this.height = height;
            this.mapColors = mapColors;
        }

        public WrappedMapPatch() {
        }

        public int getStartX() {
            return startX;
        }

        public void setStartX(int startX) {
            this.startX = startX;
        }

        public int getStartY() {
            return startY;
        }

        public void setStartY(int startY) {
            this.startY = startY;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public byte[] getMapColors() {
            return mapColors;
        }

        public void setMapColors(byte[] mapColors) {
            this.mapColors = mapColors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedMapPatch that = (WrappedMapPatch) o;

            if (startX != that.startX) return false;
            if (startY != that.startY) return false;
            if (width != that.width) return false;
            if (height != that.height) return false;
            return Arrays.equals(mapColors, that.mapColors);
        }

        @Override
        public int hashCode() {
            int result = startX;
            result = 31 * result + startY;
            result = 31 * result + width;
            result = 31 * result + height;
            result = 31 * result + Arrays.hashCode(mapColors);
            return result;
        }

        @Override
        public String toString() {
            return "WrappedMapPatch{" +
                    "startX=" + startX +
                    ", startY=" + startY +
                    ", width=" + width +
                    ", height=" + height +
                    ", mapColors=" + Arrays.toString(mapColors) +
                    '}';
        }
    }

    public static class WrappedMapDecoration {
        private static final Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("world.level.saveddata.maps.MapDecoration", "world.level.saveddata.maps.MapIcon");
        static final EquivalentConverter<WrappedMapDecoration> CONVERTER = AutoWrapper.wrap(WrappedMapDecoration.class, HANDLE_TYPE)
                .field(0, TYPE_CONVERTER)
                .field(4, BukkitConverters.getWrappedChatComponentConverter());
        private DecorationType type;
        private byte x;
        private byte y;
        private byte rot;
        private WrappedChatComponent name;

        public WrappedMapDecoration() {
        }

        public WrappedMapDecoration(DecorationType type, byte x, byte y, byte rot, @Nullable WrappedChatComponent name) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.rot = rot;
            this.name = name;
        }

        @Override
        public String toString() {
            return "WrappedMapDecoration{" +
                    "type=" + type +
                    ", x=" + x +
                    ", y=" + y +
                    ", rot=" + rot +
                    ", name=" + name +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedMapDecoration that = (WrappedMapDecoration) o;

            if (x != that.x) return false;
            if (y != that.y) return false;
            if (rot != that.rot) return false;
            if (type != that.type) return false;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + (int) x;
            result = 31 * result + (int) y;
            result = 31 * result + (int) rot;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        public DecorationType getType() {
            return type;
        }

        public void setType(DecorationType type) {
            this.type = type;
        }

        public byte getX() {
            return x;
        }

        public void setX(byte x) {
            this.x = x;
        }

        public byte getY() {
            return y;
        }

        public void setY(byte y) {
            this.y = y;
        }

        public byte getRot() {
            return rot;
        }

        public void setRot(byte rot) {
            this.rot = rot;
        }

        @Nullable
        public WrappedChatComponent getName() {
            return name;
        }

        public void setName(@Nullable WrappedChatComponent name) {
            this.name = name;
        }
    }

    private static final Class<?> TYPE_CLASS = MinecraftReflection.getMinecraftClass("world.level.saveddata.maps.MapDecoration$Type", "world.level.saveddata.maps.MapIcon$Type");
    private static final EquivalentConverter<DecorationType> TYPE_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(DecorationType.class, TYPE_CLASS);

    public enum DecorationType {
        PLAYER,
        FRAME,
        RED_MARKER,
        BLUE_MARKER,
        TARGET_X,
        TARGET_POINT,
        PLAYER_OFF_MAP,
        PLAYER_OFF_LIMITS,
        MANSION,
        MONUMENT,
        BANNER_WHITE,
        BANNER_ORANGE,
        BANNER_MAGENTA,
        BANNER_LIGHT_BLUE,
        BANNER_YELLOW,
        BANNER_LIME,
        BANNER_PINK,
        BANNER_GRAY,
        BANNER_LIGHT_GRAY,
        BANNER_CYAN,
        BANNER_PURPLE,
        BANNER_BLUE,
        BANNER_BROWN,
        BANNER_GREEN,
        BANNER_RED,
        BANNER_BLACK,
        RED_X
    }
}

