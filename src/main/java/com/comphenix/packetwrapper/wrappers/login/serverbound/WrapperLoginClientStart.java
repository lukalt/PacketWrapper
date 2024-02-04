package com.comphenix.packetwrapper.wrappers.login.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.Converters;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class WrapperLoginClientStart extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Login.Client.START;

    public WrapperLoginClientStart() {
        super(TYPE);
    }

    public WrapperLoginClientStart(PacketContainer packet) {
        super(packet, TYPE);
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
     * Legacy method to get the profile id as an optional, which will be present every time
     * @deprecated
     * @return 'profileId'
     */
    @Deprecated
    public Optional<UUID> getProfileId() {
        return Optional.of(this.getProfileIdDirectly());
    }


    /**
     * Retrieves the value of field 'profileId'
     * @return 'profileId'
     */
    public UUID getProfileIdDirectly() {
        return this.handle.getUUIDs().read(0);
    }

    /**
     * Sets the value of field 'profileId'
     *
     * @param value New value for field 'profileId'
     */
    public void setProfileId(UUID value) {
        this.getHandle().getUUIDs().write(0, value);
    }

}
