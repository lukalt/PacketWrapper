package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.ReflectiveAdventureComponentConverter;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.ComponentConverter;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import net.md_5.bungee.api.chat.BaseComponent;

public class WrapperPlayServerSetSubtitleText extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Server.SET_SUBTITLE_TEXT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerSetSubtitleText() {
        super(TYPE);
    }

    public WrapperPlayServerSetSubtitleText(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the subtitle as a chat component
     *
     * @return 'text' subtitle component
     */
    public WrappedChatComponent getText() {
        WrappedChatComponent read = this.handle.getChatComponents().read(0);
        if(read != null) {
            return read;
        }
        Object adventure = this.handle.getModifier().read(1);
        if(adventure != null) {
            return ReflectiveAdventureComponentConverter.fromComponent(adventure);
        }
        BaseComponent[] baseComponents = (BaseComponent[]) this.handle.getModifier().read(2);
        return ComponentConverter.fromBaseComponent(baseComponents);
    }

    /**
     * Sets the subtitle as a chat component
     *
     * @param value New value for field 'text'
     */
    public void setText(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
        StructureModifier<Object> structures = this.handle.getModifier();
        if(structures.size() > 1) {
            for(int i = 1; i < structures.size(); i++) {
                structures.write(i, null);
            }
        }
    }

}
