package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.MethodAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

import java.util.List;
import java.util.Objects;

public class WrapperPlayServerTabComplete extends AbstractPacket {

    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.TAB_COMPLETE;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerTabComplete() {
        super(TYPE);
    }

    /**
     * Constructors a new wrapper for the specified packet
     *
     * @param packet the packet to wrap
     */
    public WrapperPlayServerTabComplete(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'id'
     *
     * @return 'id'
     */
    public int getId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'id'
     *
     * @param value New value for field 'id'
     */
    public void setId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'suggestions'
     *
     * @return 'suggestions'
     * @deprecated {Use {@link WrapperPlayServerTabComplete#getSuggestions()} instead}
     */
    @Deprecated
    public InternalStructure getSuggestionsInternal() {
        return this.handle.getStructures().read(0);
    }

    /**
     * Sets the value of field 'suggestions'
     *
     * @param value New value for field 'suggestions'
     * @deprecated {Use {@link WrapperPlayServerTabComplete#setSuggestions(WrappedSuggestions)} instead}
     */
    @Deprecated
    public void setSuggestionsInternal(InternalStructure value) {
        this.handle.getStructures().write(0, value);
    }

    /**
     * Retrieves the value of field 'suggestions'
     *
     * @return 'suggestions'
     */
    public WrappedSuggestions getSuggestions() {
        return this.handle.getModifier().withType(WrappedSuggestions.HANDLE_TYPE, WrappedSuggestions.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'suggestions'
     *
     * @param value New value for field 'suggestions'
     */
    public void setSuggestions(WrappedSuggestions value) {
        this.handle.getModifier().withType(WrappedSuggestions.HANDLE_TYPE, WrappedSuggestions.CONVERTER).write(0, value);
    }

    public static class WrappedStringRange {
        private final static EquivalentConverter<WrappedStringRange> CONVERTER = AutoWrapper.wrap(WrappedStringRange.class,
                MinecraftReflection.getLibraryClass("com.mojang.brigadier.context.StringRange"));

        private int start;
        private int end;

        public WrappedStringRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public WrappedStringRange() {
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedStringRange that = (WrappedStringRange) o;

            if (start != that.start) return false;
            return end == that.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        @Override
        public String toString() {
            return "WrappedStringRange{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static class WrappedSuggestions {
        public static final Class<?> HANDLE_TYPE = MinecraftReflection.getLibraryClass("com.mojang.brigadier.suggestion.Suggestions");
        private static final EquivalentConverter<WrappedSuggestions> CONVERTER = AutoWrapper.wrap(WrappedSuggestions.class,
                        HANDLE_TYPE)
                .field(0, WrappedStringRange.CONVERTER)
                .field(1, BukkitConverters.getListConverter(WrappedSuggestion.CONVERTER));
        private WrappedStringRange range;
        private List<WrappedSuggestion> suggestions;

        public WrappedSuggestions(WrappedStringRange range, List<WrappedSuggestion> suggestions) {
            this.range = range;
            this.suggestions = suggestions;
        }

        public WrappedSuggestions() {
        }

        public WrappedStringRange getRange() {
            return range;
        }

        public void setRange(WrappedStringRange range) {
            this.range = range;
        }

        public List<WrappedSuggestion> getSuggestions() {
            return suggestions;
        }

        public void setSuggestions(List<WrappedSuggestion> suggestions) {
            this.suggestions = suggestions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedSuggestions that = (WrappedSuggestions) o;

            if (!Objects.equals(range, that.range)) return false;
            return Objects.equals(suggestions, that.suggestions);
        }

        @Override
        public int hashCode() {
            int result = range != null ? range.hashCode() : 0;
            result = 31 * result + (suggestions != null ? suggestions.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "WrappedSuggestions{" +
                    "range=" + range +
                    ", suggestions=" + suggestions +
                    '}';
        }
    }

    public static class WrappedSuggestion {
        private final static EquivalentConverter<WrappedSuggestion> CONVERTER = AutoWrapper.wrap(WrappedSuggestion.class,
                        MinecraftReflection.getLibraryClass("com.mojang.brigadier.suggestion.Suggestion"))
                .field(0, WrappedStringRange.CONVERTER)
                .field(2, WrappedMessage.CONVERTER);
        private WrappedStringRange range;
        private String text;
        private WrappedMessage tooltip;

        public WrappedSuggestion(WrappedStringRange range, String text, WrappedMessage tooltip) {
            this.range = range;
            this.text = text;
            this.tooltip = tooltip;
        }

        public WrappedSuggestion() {
        }

        public WrappedStringRange getRange() {
            return range;
        }

        public void setRange(WrappedStringRange range) {
            this.range = range;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public WrappedMessage getTooltip() {
            return tooltip;
        }

        public void setTooltip(WrappedMessage tooltip) {
            this.tooltip = tooltip;
        }

        @Override
        public String toString() {
            return "WrappedSuggestion{" +
                    "range=" + range +
                    ", text='" + text + '\'' +
                    ", tooltip=" + tooltip +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedSuggestion that = (WrappedSuggestion) o;

            if (!Objects.equals(range, that.range)) return false;
            if (!Objects.equals(text, that.text)) return false;
            return Objects.equals(tooltip, that.tooltip);
        }

        @Override
        public int hashCode() {
            int result = range != null ? range.hashCode() : 0;
            result = 31 * result + (text != null ? text.hashCode() : 0);
            result = 31 * result + (tooltip != null ? tooltip.hashCode() : 0);
            return result;
        }
    }

    public static class WrappedComponentMessage implements WrappedMessage {
        private static MethodAccessor GET_STRING_METHOD;
        private static Class<?> MESSAGE_TYPE;


        private final static EquivalentConverter<WrappedComponentMessage> CONVERTER = new EquivalentConverter<WrappedComponentMessage>() {
            @Override
            public Object getGeneric(WrappedComponentMessage specific) {
                return specific.component.getHandle();
            }

            @Override
            public WrappedComponentMessage getSpecific(Object generic) {
                return new WrappedComponentMessage(WrappedChatComponent.fromHandle(generic));
            }

            @Override
            public Class<WrappedComponentMessage> getSpecificType() {
                return WrappedComponentMessage.class;
            }
        };

        private WrappedChatComponent component;

        public WrappedComponentMessage(WrappedChatComponent component) {
            this.component = component;
        }

        public WrappedChatComponent getComponent() {
            return component;
        }

        public void setComponent(WrappedChatComponent component) {
            this.component = component;
        }

        @Override
        public String toString() {
            return "WrappedComponentMessage{" +
                    "component=" + component +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedComponentMessage that = (WrappedComponentMessage) o;

            return Objects.equals(component, that.component);
        }

        @Override
        public int hashCode() {
            return component != null ? component.hashCode() : 0;
        }

        @Override
        public String getString() {
            if (MESSAGE_TYPE == null) {
                MESSAGE_TYPE = MinecraftReflection.getLibraryClass("com.mojang.brigadier.Message");
            }
            if (GET_STRING_METHOD == null) {
                GET_STRING_METHOD = Accessors.getMethodAccessor(MESSAGE_TYPE, "getString");
            }
            return (String) GET_STRING_METHOD.invoke(component.getHandle());
        }
    }

    public static class WrappedLiteralMessage implements WrappedMessage {
        private final static Class<?> HANDLE_TYPE = MinecraftReflection.getLibraryClass("com.mojang.brigadier.LiteralMessage");
        private final static EquivalentConverter<WrappedLiteralMessage> CONVERTER = AutoWrapper.wrap(WrappedLiteralMessage.class, HANDLE_TYPE);

        private String string;

        public WrappedLiteralMessage(String string) {
            this.string = string;
        }

        public WrappedLiteralMessage() {
        }

        @Override
        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedLiteralMessage that = (WrappedLiteralMessage) o;

            return Objects.equals(string, that.string);
        }

        @Override
        public int hashCode() {
            return string != null ? string.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "WrappedLiteralMessage{" +
                    "string='" + string + '\'' +
                    '}';
        }
    }

    public interface WrappedMessage {
        EquivalentConverter<WrappedMessage> CONVERTER = new EquivalentConverter<>() {
            @Override
            public Object getGeneric(WrappedMessage specific) {
                if (specific instanceof WrappedLiteralMessage) {
                    return WrappedLiteralMessage.CONVERTER.getGeneric((WrappedLiteralMessage) specific);
                } else if (specific instanceof WrappedComponentMessage) {
                    return WrappedComponentMessage.CONVERTER.getGeneric((WrappedComponentMessage) specific);
                }
                throw new IllegalArgumentException("Invalid wrapped message: " + specific);
            }

            @Override
            public WrappedMessage getSpecific(Object generic) {
                if (generic.getClass().equals(WrappedLiteralMessage.HANDLE_TYPE)) {
                    return WrappedLiteralMessage.CONVERTER.getSpecific(generic);
                }
                return WrappedComponentMessage.CONVERTER.getSpecific(generic);
            }

            @Override
            public Class<WrappedMessage> getSpecificType() {
                return WrappedMessage.class;
            }
        };

        String getString();
    }
}
