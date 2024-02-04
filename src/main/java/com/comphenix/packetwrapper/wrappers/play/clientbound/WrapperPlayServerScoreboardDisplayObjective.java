package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.scoreboard.DisplaySlot;

public class WrapperPlayServerScoreboardDisplayObjective extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_DISPLAY_OBJECTIVE;
    private static final Class<?> DISPLAY_SLOT_CLASS = MinecraftReflection.getMinecraftClass("world.scores.DisplaySlot");
    private static final EquivalentConverter<DisplaySlot> DISPLAY_SLOT_CONVERTER = new EnumWrappers.IndexedEnumConverter<>(DisplaySlot.class, DISPLAY_SLOT_CLASS);
    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerScoreboardDisplayObjective() {
        super(TYPE);
    }

    public WrapperPlayServerScoreboardDisplayObjective(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'slot'
     * @deprecated
     * Use {@see WrapperPlayServerScoreboardDisplayObjective#getDisplaySlot} instead
     * @return 'slot'
     */
    @Deprecated
    public int getSlot() {
        return getDisplaySlot().ordinal();
    }

    /**
     * Sets the value of field 'slot'
     * @deprecated
     * Use {@see WrapperPlayServerScoreboardDisplayObjective#setDisplaySlot} instead
     * @param value New value for field 'slot'
     */
    @Deprecated
    public void setSlot(int value) {
        this.setDisplaySlot(DisplaySlot.values()[value]);
    }

    public DisplaySlot getDisplaySlot() {
        return this.handle.getModifier().withType(DISPLAY_SLOT_CLASS, DISPLAY_SLOT_CONVERTER).read(0);
    }

    public void setDisplaySlot(DisplaySlot displaySlot) {
        this.handle.getModifier().withType(DISPLAY_SLOT_CLASS, DISPLAY_SLOT_CONVERTER).write(0, displaySlot);
    }

    /**
     * Retrieves the value of field 'objectiveName'
     *
     * @return 'objectiveName'
     */
    public String getObjectiveName() {
        return this.handle.getStrings().read(0);
    }

    /**
     * Sets the value of field 'objectiveName'
     *
     * @param value New value for field 'objectiveName'
     */
    public void setObjectiveName(String value) {
        this.handle.getStrings().write(0, value);
    }

}
