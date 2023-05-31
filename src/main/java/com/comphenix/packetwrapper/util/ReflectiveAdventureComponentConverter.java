package com.comphenix.packetwrapper.util;

import com.comphenix.protocol.reflect.FuzzyReflection;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.reflect.accessors.MethodAccessor;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class ReflectiveAdventureComponentConverter {
    private static final Class<?> COMPONENT_CLASS = MinecraftReflection.getLibraryClass("net.kyori.adventure.text.Component");
    private static final Class<?> GSON_COMPONENT_SERIALIZER_CLASS = MinecraftReflection.getLibraryClass("net.kyori.adventure.text.serializer.gson.GsonComponentSerializer");
    private static final Class<?> COMPONENT_SERIALIZER_CLASS = MinecraftReflection.getLibraryClass("net.kyori.adventure.text.serializer.ComponentSerializer");

    private static final MethodAccessor GET_GSON_SERIALIZER_METHOD = Accessors.getMethodAccessor(GSON_COMPONENT_SERIALIZER_CLASS, "gson");
    private static final MethodAccessor DESERIALIZE_METHOD = Accessors.getMethodAccessor(FuzzyReflection.fromClass(COMPONENT_SERIALIZER_CLASS, false).getMethodByName("deserializeOrNull"));
    private static final MethodAccessor SERIALIZE_METHOD = Accessors.getMethodAccessor(FuzzyReflection.fromClass(COMPONENT_SERIALIZER_CLASS, false).getMethodByName("serialize"));

    private static Object GSON_SERIALIZER;

    private static Object getGsonSerializer() {
        if(GSON_SERIALIZER == null) {
            GSON_SERIALIZER = GET_GSON_SERIALIZER_METHOD.invoke(null);
        }
        return GSON_SERIALIZER;
    }

    public static Object fromWrapper(WrappedChatComponent wrapper) {
        return DESERIALIZE_METHOD.invoke(getGsonSerializer(), wrapper.getJson());
    }

    public static WrappedChatComponent fromComponent(Object component) {
        return WrappedChatComponent.fromJson((String)SERIALIZE_METHOD.invoke(getGsonSerializer(), component));
    }

    public static String componentToString(Object component) {
        return (String)SERIALIZE_METHOD.invoke(getGsonSerializer(), component);
    }

    public static Class<?> getComponentClass() {
        return COMPONENT_CLASS;
    }
}
