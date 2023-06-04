package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Send by server to client to add players to player list or to update information.
 * Use {@link WrapperPlayServerPlayerInfoRemove} to remove player info. {@see EnumWrappers.PlayerInfoAction.REMOVE_PLAYER} is no longer supported.
 */
public class WrapperPlayServerPlayerInfo extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_INFO;

    /**
     * Set of all actions that should be used to spawn a new player.
     */
    public static final Set<EnumWrappers.PlayerInfoAction> ALL_ACTIONS = new HashSet<>(Arrays.asList(
            EnumWrappers.PlayerInfoAction.ADD_PLAYER,
            EnumWrappers.PlayerInfoAction.UPDATE_LATENCY,
            EnumWrappers.PlayerInfoAction.UPDATE_DISPLAY_NAME,
            EnumWrappers.PlayerInfoAction.UPDATE_GAME_MODE,
            EnumWrappers.PlayerInfoAction.UPDATE_LISTED,
            EnumWrappers.PlayerInfoAction.INITIALIZE_CHAT
    ));

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerPlayerInfo() {
        super(TYPE);
    }

    public WrapperPlayServerPlayerInfo(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Gets a set of action that determines the fields of the {@link PlayerInfoData} that will be updated.
     *
     * @return set of fields to update
     */
    public Set<EnumWrappers.PlayerInfoAction> getActions() {
        return this.handle.getPlayerInfoActions().read(0);
    }

    /**
     * Sets a set of action that determines the fields of the {@link PlayerInfoData} that will be updated.
     * Use {@link WrapperPlayServerPlayerInfoRemove} to remove player info. {@see EnumWrappers.PlayerInfoAction.REMOVE_PLAYER} is no longer supported.
     * Use {@link WrapperPlayServerPlayerInfo#ALL_ACTIONS} when adding a new player.
     *
     * @param value Actions for this update.
     */
    public void setActions(Set<EnumWrappers.PlayerInfoAction> value) {
        if (value.contains(EnumWrappers.PlayerInfoAction.REMOVE_PLAYER)) {
            throw new IllegalArgumentException("PlayerInfoAction.REMOVE_PLAYER has been removed. Use PacketType.Play.Server.PLAYER_INFO_REMOVE to remove Player Infos.");
        }
        this.handle.getPlayerInfoActions().write(0, value);
    }

    /**
     * List of entries to add/update with this packet
     * The fields of the entry to update depend on the actions specified by {@link WrapperPlayServerPlayerInfo#setActions(Set)}
     *
     * @return entries to update
     */
    public List<PlayerInfoData> getEntries() {
        return this.handle.getPlayerInfoDataLists().read(1);
    }

    /**
     * Sets the list of entries to add/update with this packet.
     * The fields of the entry to update depend on the actions specified by {@link WrapperPlayServerPlayerInfo#setActions(Set)}
     *
     * @param value List of entries to update
     */
    public void setEntries(List<PlayerInfoData> value) {
        this.handle.getPlayerInfoDataLists().write(1, value);
    }

}
