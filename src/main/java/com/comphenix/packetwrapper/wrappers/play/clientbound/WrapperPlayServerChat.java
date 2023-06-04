package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.WrappedBoundChatType;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedMessageSignature;

import java.util.BitSet;
import java.util.Objects;
import java.util.UUID;

public class WrapperPlayServerChat extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.CHAT;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerChat() {
        super(TYPE);
    }

    public WrapperPlayServerChat(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'sender'
     *
     * @return 'sender'
     */
    public UUID getSender() {
        return this.handle.getUUIDs().read(0);
    }

    /**
     * Sets the value of field 'sender'
     *
     * @param value New value for field 'sender'
     */
    public void setSender(UUID value) {
        this.handle.getUUIDs().write(0, value);
    }

    /**
     * Retrieves the value of field 'index'
     *
     * @return 'index'
     */
    public int getIndex() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'index'
     *
     * @param value New value for field 'index'
     */
    public void setIndex(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'signature'
     *
     * @return 'signature'
     */
    public WrappedMessageSignature getSignature() {
        return this.handle.getMessageSignatures().read(0);
    }

    /**
     * Sets the value of field 'signature'
     *
     * @param value New value for field 'signature'
     */
    public void setSignature(WrappedMessageSignature value) {
        this.handle.getMessageSignatures().write(0, value);
    }

    /**
     * Retrieves the value of field 'body'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'body'
     */
    @Deprecated
    public InternalStructure getBodyInternal() {
        return this.handle.getStructures().read(2); // TODO: No specific modifier has been found for type class net.minecraft.network.chat.SignedMessageBody$Packed Generic type: class net.minecraft.network.chat.SignedMessageBody$Packed
    }

    /**
     * Sets the value of field 'body'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'body'
     */
    @Deprecated
    public void setBodyInternal(InternalStructure value) {
        this.handle.getStructures().write(2, value); // TODO: No specific modifier has been found for type class net.minecraft.network.chat.SignedMessageBody$Packed Generic type: class net.minecraft.network.chat.SignedMessageBody$Packed
    }

    /**
     * Retrieves the value of field 'unsignedContent'
     *
     * @return 'unsignedContent'
     */
    public WrappedChatComponent getUnsignedContent() {
        return this.handle.getChatComponents().read(0); // TODO
    }

    /**
     * Sets the value of field 'unsignedContent'
     *
     * @param value New value for field 'unsignedContent'
     */
    public void setUnsignedContent(WrappedChatComponent value) {
        this.handle.getChatComponents().write(0, value);
    }

    /**
     * Retrieves the value of field 'filterMask'
     *
     * @return 'filterMask'
     */
    @Deprecated
    public InternalStructure getFilterMaskInternal() {
        return this.handle.getStructures().read(4);
    }

    /**
     * Sets the value of field 'filterMask'
     *
     * @param value New value for field 'filterMask'
     */
    @Deprecated
    public void setFilterMaskInternal(InternalStructure value) {
        this.handle.getStructures().write(4, value);
    }

    /**
     * Retrieves the value of field 'filterMask'
     *
     * @return 'filterMask'
     */
    public WrappedFilterMask getFilterMask() {
        return this.handle.getModifier().withType(WrappedFilterMask.HANDLE_CLASS, WrappedFilterMask.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'filterMask'
     *
     * @param value New value for field 'filterMask'
     */
    public void setFilterMask(WrappedFilterMask value) {
        this.handle.getModifier().withType(WrappedFilterMask.HANDLE_CLASS, WrappedFilterMask.CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'chatType'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'chatType'
     * @deprecated {Use {@link WrapperPlayServerChat#getChatType()} instead}
     */
    @Deprecated
    public InternalStructure getChatTypeInternal() {
        return this.handle.getStructures().read(5);
    }

    /**
     * Sets the value of field 'chatType'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'chatType'
     * @deprecated {Use {@link WrapperPlayServerChat#setChatType(WrappedBoundChatType)} instead}
     */
    @Deprecated
    public void setChatTypeInternal(InternalStructure value) {
        this.handle.getStructures().write(5, value);
    }


    /**
     * Retrieves the value of field 'chatType'
     *
     * @return 'chatType'
     */
    public WrappedBoundChatType getChatType() {
        return this.handle.getModifier().withType(WrappedBoundChatType.HANDLE_TYPE, WrappedBoundChatType.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'chatType'
     *
     * @param value New value for field 'chatType'
     */
    public void setChatType(WrappedBoundChatType value) {
        this.handle.getModifier().withType(WrappedBoundChatType.HANDLE_TYPE, WrappedBoundChatType.CONVERTER).write(0, value);
    }

    public static class WrappedFilterMask {
        final static Class<?> HANDLE_CLASS = MinecraftReflection.getMinecraftClass("network.chat.FilterMask", "network.chat.FilterMask");
        final static Class<?> TYPE_CLASS = MinecraftReflection.getMinecraftClass("network.chat.FilterMask$Type", "network.chat.FilterMask$a");
        final static EquivalentConverter<WrappedFilterMask> CONVERTER = AutoWrapper.wrap(WrappedFilterMask.class, HANDLE_CLASS)
                .field(1, FilterMaskType.getConverter());

        private BitSet bitSet;
        private FilterMaskType type;

        public WrappedFilterMask(BitSet bitSet, FilterMaskType type) {
            this.bitSet = bitSet;
            this.type = type;
        }

        public WrappedFilterMask() {
        }

        public BitSet getBitSet() {
            return bitSet;
        }

        public void setBitSet(BitSet bitSet) {
            this.bitSet = bitSet;
        }

        public FilterMaskType getType() {
            return type;
        }

        public void setType(FilterMaskType type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedFilterMask that = (WrappedFilterMask) o;

            if (!Objects.equals(bitSet, that.bitSet)) return false;
            return type == that.type;
        }

        @Override
        public int hashCode() {
            int result = bitSet != null ? bitSet.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "WrappedFilterMask{" +
                    "bitSet=" + bitSet +
                    ", type=" + type +
                    '}';
        }

        public enum FilterMaskType {
            PASS_THROUGH,
            FULLY_FILTERED,
            PARTIALLY_FILTERED;

            public static EquivalentConverter<FilterMaskType> getConverter() {
                return new EnumWrappers.IndexedEnumConverter<>(FilterMaskType.class, TYPE_CLASS);
            }
        }
    }
}
