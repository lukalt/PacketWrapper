package com.comphenix.packetwrapper.wrappers.data;

import com.comphenix.packetwrapper.wrappers.play.serverbound.WrapperPlayClientChatCommand;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.ConstructorAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.Converters;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.BitSet;
import java.util.List;
import java.util.Objects;

/**
 * @author Lukas Alt
 * @since 21.05.2023
 */

public class WrappedLastSeenMessagesUpdate {
    public final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("network.chat.LastSeenMessages$Update", "network.chat.LastSeenMessages$b");
    private static ConstructorAccessor CONSTRUCTOR;
    private final static EquivalentConverter<WrappedLastSeenMessagesUpdate> TO_SPECIFIC = AutoWrapper.wrap(WrappedLastSeenMessagesUpdate.class, HANDLE_TYPE)
            .field(1, Converters.passthrough(BitSet.class));

    public final static EquivalentConverter<WrappedLastSeenMessagesUpdate> CONVERTER = new EquivalentConverter<>() {
        @Override
        public Object getGeneric(WrappedLastSeenMessagesUpdate wrappedMessageUpdate) {
            ByteBuf buf = Unpooled.buffer();
            buf.writeByte(0); // VarInt == Byte for value 0
            buf.writeBytes(new byte[-Math.floorDiv(-20, 8)]);
            Object packetDataSerializer = MinecraftReflection.getPacketDataSerializer(buf);
            if (CONSTRUCTOR == null) {
                CONSTRUCTOR = Accessors.getConstructorAccessor(HANDLE_TYPE.getConstructors()[0]);
            }
            Object handle = CONSTRUCTOR.invoke(packetDataSerializer);
            StructureModifier<?> modifier = new StructureModifier<>(handle.getClass()).withTarget(handle);
            modifier.withType(int.class).write(0, wrappedMessageUpdate.offset);
            modifier.withType(BitSet.class).write(0, wrappedMessageUpdate.acknowledged);
            return handle;
        }

        @Override
        public WrappedLastSeenMessagesUpdate getSpecific(Object o) {
            return TO_SPECIFIC.getSpecific(o);
        }

        @Override
        public Class<WrappedLastSeenMessagesUpdate> getSpecificType() {
            return WrappedLastSeenMessagesUpdate.class;
        }
    };
    private int offset;
    private BitSet acknowledged;

    public WrappedLastSeenMessagesUpdate(int offset, BitSet acknowledged) {
        this.offset = offset;
        this.acknowledged = acknowledged;
    }

    public WrappedLastSeenMessagesUpdate() {
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public BitSet getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(BitSet acknowledged) {
        this.acknowledged = acknowledged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WrappedLastSeenMessagesUpdate that = (WrappedLastSeenMessagesUpdate) o;

        if (offset != that.offset) return false;
        return Objects.equals(acknowledged, that.acknowledged);
    }

    @Override
    public int hashCode() {
        int result = offset;
        result = 31 * result + (acknowledged != null ? acknowledged.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WrappedLastSeenMessagesUpdate{" +
                "offset=" + offset +
                ", acknowledged=" + acknowledged +
                '}';
    }
}