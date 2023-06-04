package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.ReflectiveAdventureComponentConverter;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.ComponentConverter;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import net.md_5.bungee.api.chat.BaseComponent;

public class WrapperPlayServerSetTitleText extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.SET_TITLE_TEXT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetTitleText() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerSetTitleText(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the main title as a chat component
     *
     * @return 'text'
     */
    public WrappedChatComponent getText() {
        WrappedChatComponent read = this.handle.getChatComponents().read(0);
        if (read != null) {
            return read;
        }
        Object adventure = this.handle.getModifier().read(1);
        if (adventure != null) {
            return ReflectiveAdventureComponentConverter.fromComponent(adventure);
        }
        BaseComponent[] baseComponents = (BaseComponent[]) this.handle.getModifier().read(2);
        return ComponentConverter.fromBaseComponent(baseComponents);
    }

    /**
     * Sets the main title as a chat component
     *
     * @param value New value for field 'text'
     */
    public void setText(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
        StructureModifier<Object> structures = this.handle.getModifier();
        if (structures.size() > 1) {
            for (int i = 1; i < structures.size(); i++) {
                structures.write(i, null);
            }
        }
    }
}
