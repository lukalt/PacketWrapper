package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.FuzzyReflection;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.ConstructorAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.*;
import org.bukkit.ChatColor;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WrapperPlayServerScoreboardTeam extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_TEAM;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerScoreboardTeam() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerScoreboardTeam(PacketContainer packet) {
        super(packet, TYPE);
    }

    public enum Method {
        CREATE_TEAM,
        REMOVE_TEAM,
        UPDATE_TEAM_INFO,
        ADD_PLAYER,
        REMOVE_PLAYER
    }

    /**
     * Retrieves the index of the type of this operations
     *
     * @return 'method'
     */
    public int getMethod() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Retrieves the type of this operation
     *
     * @return type of operation
     */
    @UtilityMethod
    public Method getMethodEnum() {
        return Method.values()[this.getMethod()];
    }

    /**
     * Sets the index of the type of this operation
     *
     * @param value New value for field 'method'
     * @see WrapperPlayServerScoreboardTeam#setMethodEnum(Method)
     */
    public void setMethod(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Sets the type of this operation
     *
     * @param method The method
     */
    @UtilityMethod
    public void setMethodEnum(Method method) {
        this.setMethod(method.ordinal());
    }

    /**
     * Retrieves the value of field 'name'
     *
     * @return 'name'
     */
    public String getName() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'name'
     *
     * @param value New value for field 'name'
     */
    public void setName(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'players'
     *
     * @return 'players'
     */
    public List<String> getPlayers() {
        return this.handle.getModifier().withType(Collection.class, BukkitConverters.getListConverter(Converters.passthrough(String.class))).read(0);
    }

    /**
     * Sets the value of field 'players'
     *
     * @param value New value for field 'players'
     */
    public void setPlayers(List<String> value) {
        this.handle.getModifier().withType(Collection.class, BukkitConverters.getListConverter(Converters.passthrough(String.class))).write(0, value);
    }

    /**
     * Retrieves the value of field 'parameters'
     *
     * @return 'parameters'
     */
    public Optional<WrappedParameters> getParameters() {
        return this.handle.getOptionals(WrappedParameters.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'parameters'
     *
     * @param value New value for field 'parameters'
     */
    public void setParameters(@Nullable WrappedParameters value) {
        this.handle.getOptionals(WrappedParameters.CONVERTER).write(0, Optional.ofNullable(value));
    }

    public static class WrappedParameters {
        private final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("network.protocol.game.ClientboundSetPlayerTeamPacket$Parameters", "network.protocol.game.PacketPlayOutScoreboardTeam$b");
        private final static Class<?> COLOR_TYPE = MinecraftReflection.getMinecraftClass("ChatFormatting", "EnumChatFormat");
        private final static Class<?> PLAYER_TEAM_TYPE = MinecraftReflection.getMinecraftClass("world.scores.PlayerTeam", "world.scores.ScoreboardTeam");
        private final static ConstructorAccessor HANDLE_CONSTRUCTOR = Accessors.getConstructorAccessor(HANDLE_TYPE, PLAYER_TEAM_TYPE);
        private final static ConstructorAccessor PLAYER_TEAM_CONSTRUCTOR = Accessors.getConstructorAccessor(FuzzyReflection.fromClass(PLAYER_TEAM_TYPE, false).getConstructors().iterator().next());

        public static final EnumWrappers.IndexedEnumConverter<ChatColor> COLOR_CONVERTER = new EnumWrappers.IndexedEnumConverter(ChatColor.class, COLOR_TYPE);
        final static EquivalentConverter<WrappedParameters> TO_SPECIFIC_CONVERTER = AutoWrapper.wrap(WrappedParameters.class, HANDLE_TYPE)
                .field(0, BukkitConverters.getWrappedChatComponentConverter())
                .field(1, BukkitConverters.getWrappedChatComponentConverter())
                .field(2, BukkitConverters.getWrappedChatComponentConverter())
                .field(5, COLOR_CONVERTER);
        final static EquivalentConverter<WrappedParameters> CONVERTER = new EquivalentConverter<>() {
            @Override
            public Object getGeneric(WrappedParameters specific) {
                Object playerTeamHandle = PLAYER_TEAM_CONSTRUCTOR.invoke(null, "dummy");
                Object handle = HANDLE_CONSTRUCTOR.invoke(playerTeamHandle);
                StructureModifier<?> modifier = new StructureModifier<>(HANDLE_TYPE).withTarget(handle);
                modifier.withType(MinecraftReflection.getIChatBaseComponentClass(), BukkitConverters.getWrappedChatComponentConverter())
                        .write(0, specific.displayName)
                        .write(1, specific.playerPrefix)
                        .write(2, specific.playerSuffix);
                modifier.withType(String.class).write(0, specific.nametagVisibility)
                        .write(1, specific.collisionRule);

                modifier.withType(COLOR_TYPE, COLOR_CONVERTER).write(0, specific.color);
                modifier.withType(int.class).write(0, specific.options);
                return handle;
            }

            @Override
            public WrappedParameters getSpecific(Object generic) {
                return TO_SPECIFIC_CONVERTER.getSpecific(generic);
            }

            @Override
            public Class<WrappedParameters> getSpecificType() {
                return WrappedParameters.class;
            }
        };

        private WrappedChatComponent displayName;
        private WrappedChatComponent playerPrefix;
        private WrappedChatComponent playerSuffix;
        private String nametagVisibility;
        private String collisionRule;
        private ChatColor color;
        private int options;

        public WrappedParameters(WrappedChatComponent displayName, WrappedChatComponent playerPrefix, WrappedChatComponent playerSuffix, String nametagVisibility, String collisionRule, ChatColor color, int options) {
            this.displayName = displayName;
            this.playerPrefix = playerPrefix;
            this.playerSuffix = playerSuffix;
            this.nametagVisibility = nametagVisibility;
            this.collisionRule = collisionRule;
            this.color = color;
            this.options = options;
        }

        public WrappedParameters() {
        }

        public WrappedChatComponent getDisplayName() {
            return displayName;
        }

        public void setDisplayName(WrappedChatComponent displayName) {
            this.displayName = displayName;
        }

        public WrappedChatComponent getPlayerPrefix() {
            return playerPrefix;
        }

        public void setPlayerPrefix(WrappedChatComponent playerPrefix) {
            this.playerPrefix = playerPrefix;
        }

        public WrappedChatComponent getPlayerSuffix() {
            return playerSuffix;
        }

        public void setPlayerSuffix(WrappedChatComponent playerSuffix) {
            this.playerSuffix = playerSuffix;
        }

        public String getNametagVisibility() {
            return nametagVisibility;
        }

        public void setNametagVisibility(String nametagVisibility) {
            this.nametagVisibility = nametagVisibility;
        }

        public String getCollisionRule() {
            return collisionRule;
        }

        public void setCollisionRule(String collisionRule) {
            this.collisionRule = collisionRule;
        }

        public ChatColor getColor() {
            return color;
        }

        public void setColor(ChatColor color) {
            this.color = color;
        }

        public int getOptions() {
            return options;
        }

        public void setOptions(int options) {
            this.options = options;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedParameters that = (WrappedParameters) o;

            if (options != that.options) return false;
            if (!Objects.equals(displayName, that.displayName)) return false;
            if (!Objects.equals(playerPrefix, that.playerPrefix))
                return false;
            if (!Objects.equals(playerSuffix, that.playerSuffix))
                return false;
            if (!Objects.equals(nametagVisibility, that.nametagVisibility))
                return false;
            if (!Objects.equals(collisionRule, that.collisionRule))
                return false;
            return color == that.color;
        }

        @Override
        public int hashCode() {
            int result = displayName != null ? displayName.hashCode() : 0;
            result = 31 * result + (playerPrefix != null ? playerPrefix.hashCode() : 0);
            result = 31 * result + (playerSuffix != null ? playerSuffix.hashCode() : 0);
            result = 31 * result + (nametagVisibility != null ? nametagVisibility.hashCode() : 0);
            result = 31 * result + (collisionRule != null ? collisionRule.hashCode() : 0);
            result = 31 * result + (color != null ? color.hashCode() : 0);
            result = 31 * result + options;
            return result;
        }

        @Override
        public String toString() {
            return "WrappedParameters{" +
                    "displayName=" + displayName +
                    ", playerPrefix=" + playerPrefix +
                    ", playerSuffix=" + playerSuffix +
                    ", nametagVisibility='" + nametagVisibility + '\'' +
                    ", collisionRule='" + collisionRule + '\'' +
                    ", color=" + color +
                    ", options=" + options +
                    '}';
        }
    }

}
