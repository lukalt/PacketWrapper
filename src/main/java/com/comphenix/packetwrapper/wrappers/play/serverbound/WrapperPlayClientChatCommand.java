package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.packetwrapper.wrappers.data.WrappedLastSeenMessagesUpdate;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.ConstructorAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.WrappedMessageSignature;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Send from client to server when a (signed) command should be executed.
 */
public class WrapperPlayClientChatCommand extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.CHAT_COMMAND;

    public WrapperPlayClientChatCommand() {
        super(TYPE);
    }

    public WrapperPlayClientChatCommand(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the name of the command (without arguments)
     *
     * @return name of command
     */
    public String getCommand() {
        return this.handle.getStrings().read(0);

    }

    /**
     * Sets the value of the command without arguments
     *
     * @param value name of command
     */
    public void setCommand(String value) {
        this.handle.getStrings().write(0, value);
    }

    /**
     * Retrieves the value of field 'timeStamp'
     *
     * @return 'timeStamp'
     */
    public Instant getTimeStamp() {
        return this.handle.getInstants().read(0);
    }

    /**
     * Sets the value of field 'timeStamp'
     *
     * @param value New value for field 'timeStamp'
     */
    public void setTimeStamp(Instant value) {
        this.handle.getInstants().write(0, value);
    }

    /**
     * Retrieves the salt to verify signatures
     *
     * @return 'salt'
     */
    public long getSalt() {
        return this.handle.getLongs().read(0);
    }

    /**
     * Sets the salt to verify signatures
     *
     * @param value New value for field 'salt'
     */
    public void setSalt(long value) {
        this.handle.getLongs().write(0, value);
    }

    /**
     * Retrieves the value of field 'argumentSignatures'
     *
     * @return 'argumentSignatures'
     * @deprecated {Use {@link WrapperPlayClientChatCommand#getArgumentSignatures()} instead}
     */
    public InternalStructure getArgumentSignaturesInternal() {
        return this.handle.getStructures().read(3);
    }

    /**
     * Sets the value of field 'argumentSignatures'
     *
     * @param value New value for field 'argumentSignatures'
     * @deprecated {Use {@link WrapperPlayClientChatCommand#setArgumentSignatures(WrappedArgumentSignatures)} instead}
     */
    @Deprecated
    public void setArgumentSignaturesInternal(InternalStructure value) {
        this.handle.getStructures().write(3, value);
    }

    /**
     * Gets the signed arguments for this command
     *
     * @return 'argumentSignatures'
     */
    public WrappedArgumentSignatures getArgumentSignatures() {
        return this.handle.getModifier().withType(WrappedArgumentSignatures.HANDLE_TYPE, WrappedArgumentSignatures.CONVERTER).read(0);
    }

    /**
     * Sets the signed arguments for this command
     *
     * @param value New value for field 'argumentSignatures'
     */
    public void setArgumentSignatures(WrappedArgumentSignatures value) {
        this.handle.getModifier().withType(WrappedArgumentSignatures.HANDLE_TYPE, WrappedArgumentSignatures.CONVERTER).write(0, value);
    }

    /**
     * Retrieves the value of field 'lastSeenMessages'
     *
     * @return 'lastSeenMessages'
     * @deprecated {Use {@link WrapperPlayClientChatCommand#getLastSeenMessages()} instead}
     */
    public InternalStructure getLastSeenMessagesInternal() {
        return this.handle.getStructures().read(4);
    }

    /**
     * Sets the value of field 'lastSeenMessages'
     *
     * @param value New value for field 'lastSeenMessages'
     * @deprecated {Use {@link WrapperPlayClientChatCommand#setLastSeenMessages(WrappedLastSeenMessagesUpdate)} instead}
     */
    public void setLastSeenMessagesInternal(InternalStructure value) {
        this.handle.getStructures().write(4, value);
    }

    /**
     * Retrieves the value of field 'lastSeenMessages'
     *
     * @return 'lastSeenMessages'
     */
    public WrappedLastSeenMessagesUpdate getLastSeenMessages() {
        return this.handle.getModifier().withType(WrappedLastSeenMessagesUpdate.HANDLE_TYPE, WrappedLastSeenMessagesUpdate.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'lastSeenMessages'
     *
     * @param value New value for field 'lastSeenMessages'
     */
    public void setLastSeenMessages(WrappedLastSeenMessagesUpdate value) {
        this.handle.getModifier().withType(WrappedLastSeenMessagesUpdate.HANDLE_TYPE, WrappedLastSeenMessagesUpdate.CONVERTER).write(0, value);
    }


    public static class WrappedArgumentSignatures {
        private final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("commands.arguments.ArgumentSignatures");
        private static ConstructorAccessor CONSTRUCTOR;
        private final static EquivalentConverter<WrappedArgumentSignatures> TO_SPECIFIC = AutoWrapper.wrap(WrappedArgumentSignatures.class, HANDLE_TYPE)
                .field(0, BukkitConverters.getListConverter(WrappedArgumentSignature.CONVERTER));


        private final static EquivalentConverter<WrappedArgumentSignatures> CONVERTER = new EquivalentConverter<>() {
            @Override
            public Object getGeneric(WrappedArgumentSignatures wrappedArgumentSignatures) {
                ByteBuf buf = Unpooled.buffer(8);
                buf.writeByte(0); // VarInt == Byte for value 0
                Object packetDataSerializer = MinecraftReflection.getPacketDataSerializer(buf);
                if (CONSTRUCTOR == null) {
                    CONSTRUCTOR = Accessors.getConstructorAccessor(HANDLE_TYPE.getConstructors()[0]);
                }
                Object handle = CONSTRUCTOR.invoke(packetDataSerializer);
                StructureModifier<?> modifier = new StructureModifier<>(handle.getClass()).withTarget(handle);
                modifier.withType(List.class, BukkitConverters.getListConverter(WrappedArgumentSignature.CONVERTER)).write(0, wrappedArgumentSignatures.arguments);
                return handle;
            }

            @Override
            public WrappedArgumentSignatures getSpecific(Object o) {
                return TO_SPECIFIC.getSpecific(o);
            }

            @Override
            public Class<WrappedArgumentSignatures> getSpecificType() {
                return WrappedArgumentSignatures.class;
            }
        };

        private List<WrappedArgumentSignature> arguments;

        /**
         * Constructs a list of signed arguments
         * @param arguments list of signed arguments to initialize with
         */
        public WrappedArgumentSignatures(List<WrappedArgumentSignature> arguments) {
            this.arguments = arguments;
        }

        /**
         * Constructs an empty list of signed arguments
         */
        public WrappedArgumentSignatures() {
            this.arguments = new ArrayList<>();
        }

        /**
         * Gets a mutable copy of the arguments list
         * @return mutable copy of arguments list
         */
        public List<WrappedArgumentSignature> getArguments() {
            return arguments;
        }

        /**
         * Sets the arguments list
         * @param arguments list of signed arguments
         */
        public void setArguments(List<WrappedArgumentSignature> arguments) {
            this.arguments = arguments;
        }


        @Override
        public String toString() {
            return "WrappedArgumentSignatures{" +
                    "arguments=" + arguments +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedArgumentSignatures that = (WrappedArgumentSignatures) o;

            return Objects.equals(arguments, that.arguments);
        }

        @Override
        public int hashCode() {
            return arguments != null ? arguments.hashCode() : 0;
        }
    }

    public static class WrappedArgumentSignature {
        private final static Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("commands.arguments.ArgumentSignatures$Entry", "commands.arguments.ArgumentSignatures$a");
        private static ConstructorAccessor CONSTRUCTOR;
        private final static EquivalentConverter<WrappedArgumentSignature> TO_SPECIFIC = AutoWrapper.wrap(WrappedArgumentSignature.class, HANDLE_TYPE)
                .field(1, BukkitConverters.getWrappedMessageSignatureConverter());
        private final static EquivalentConverter<WrappedArgumentSignature> CONVERTER = new EquivalentConverter<>() {
            @Override
            public Object getGeneric(WrappedArgumentSignature wrappedArgumentSignature) {
                ByteBuf buf = Unpooled.buffer(256 + 32);
                buf.writeByte(0); // VarInt == Byte for value 0
                buf.writeBytes(new byte[256]);
                Object packetDataSerializer = MinecraftReflection.getPacketDataSerializer(buf);
                if (CONSTRUCTOR == null) {
                    CONSTRUCTOR = Accessors.getConstructorAccessor(HANDLE_TYPE.getConstructors()[0]);
                }
                Object handle = CONSTRUCTOR.invoke(packetDataSerializer);
                StructureModifier<?> modifier = new StructureModifier<>(handle.getClass()).withTarget(handle);
                modifier.withType(String.class).write(0, wrappedArgumentSignature.name);
                modifier.withType(MinecraftReflection.getMessageSignatureClass(), BukkitConverters.getWrappedMessageSignatureConverter()).write(0, wrappedArgumentSignature.signature);
                return handle;
            }

            @Override
            public WrappedArgumentSignature getSpecific(Object o) {
                return TO_SPECIFIC.getSpecific(o);
            }

            @Override
            public Class<WrappedArgumentSignature> getSpecificType() {
                return WrappedArgumentSignature.class;
            }
        };

        private String name;
        private WrappedMessageSignature signature;

        /**
         * Creates a new argument with corresponding signature
         * @param name Name of the argument
         * @param signature Signature of the argument
         */
        public WrappedArgumentSignature(String name, WrappedMessageSignature signature) {
            this.name = name;
            this.signature = signature;
        }

        public WrappedArgumentSignature() {
        }

        @Override
        public String toString() {
            return "WrappedArgumentSignature{" +
                    "name='" + name + '\'' +
                    ", signature=" + signature +
                    '}';
        }

        /**
         * Get the name of the signed argument
         * @return name of the signed agument
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name of the signed argument
         * @param name name of signed argument
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets the signature of the signed argument
         * @return signature of signed argument
         */
        public WrappedMessageSignature getSignature() {
            return signature;
        }

        /**
         * Sets the signature of the signed argument
         * @param signature signature of signed argument
         */
        public void setSignature(WrappedMessageSignature signature) {
            this.signature = signature;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedArgumentSignature that = (WrappedArgumentSignature) o;

            if (!Objects.equals(name, that.name)) return false;
            return Objects.equals(signature, that.signature);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (signature != null ? signature.hashCode() : 0);
            return result;
        }
    }
}
