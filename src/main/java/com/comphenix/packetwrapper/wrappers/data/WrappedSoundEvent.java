package com.comphenix.packetwrapper.wrappers.data;

import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.Converters;
import com.comphenix.protocol.wrappers.MinecraftKey;

/**
 * @author Lukas Alt
 * @since 07.02.2024
 */
public class WrappedSoundEvent {
    private final MinecraftKey location;
    private final float range;
    private final boolean useStaticDistance;

    public static final Class<?> SOUND_EVENT_CLASS =  MinecraftReflection.getMinecraftClass("sounds.SoundEvent", "sounds.SoundEffect");

    public static final EquivalentConverter<WrappedSoundEvent> CONVERTER = AutoWrapper.wrap(WrappedSoundEvent.class,
                    SOUND_EVENT_CLASS)
            .field(0, MinecraftKey.getConverter()).field(1, MinecraftKey.getConverter())
            .field(1, Converters.passthrough(float.class))
            .field(2, Converters.passthrough(boolean.class));

    public WrappedSoundEvent(MinecraftKey location, float range, boolean useStaticDistance) {
        this.location = location;
        this.range = range;
        this.useStaticDistance = useStaticDistance;
    }

    private WrappedSoundEvent() {
        this.location = null;
        this.range = 0.0F;
        this.useStaticDistance = false;
    }

    public MinecraftKey getLocation() {
        return location;
    }

    public float getRange() {
        return range;
    }

    public boolean isUseStaticDistance() {
        return useStaticDistance;
    }
}
