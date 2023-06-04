package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.util.UtilityMethod;
import com.comphenix.packetwrapper.wrappers.AbstractPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.AutoWrapper;
import com.comphenix.protocol.wrappers.Converters;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nullable;

public class WrapperPlayServerEntityEffect extends AbstractPacket {
    /**
     * The packet type that is wrapped by this wrapper.
     */
    public static final PacketType TYPE = PacketType.Play.Server.ENTITY_EFFECT;

    public static final int FLAG_AMBIENT = 0x01;
    public static final int FLAG_SHOW_PARTICLE = 0x02;
    public static final int FLAG_SHOW_ICON = 0x04;

    /**
     * Constructs a new wrapper and initialize it with a packet handle with default values
     */
    public WrapperPlayServerEntityEffect() {
        super(TYPE);
    }

    public WrapperPlayServerEntityEffect(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieves the value of field 'entityId'
     *
     * @return 'entityId'
     */
    public int getEntityId() {
        return this.handle.getIntegers().read(0);
    }

    /**
     * Sets the value of field 'entityId'
     *
     * @param value New value for field 'entityId'
     */
    public void setEntityId(int value) {
        this.handle.getIntegers().write(0, value);
    }

    /**
     * Retrieves the value of field 'effect'
     *
     * @return 'effect'
     */
    public PotionEffectType getEffect() {
        return this.handle.getEffectTypes().read(0);
    }

    /**
     * Sets the value of field 'effect'
     *
     * @param value New value for field 'effect'
     */
    public void setEffect(PotionEffectType value) {
        this.handle.getEffectTypes().write(0, value);
    }

    /**
     * Retrieves the value of field 'effectAmplifier'
     *
     * @return 'effectAmplifier'
     */
    public byte getEffectAmplifier() {
        return this.handle.getBytes().read(0);
    }

    /**
     * Sets the value of field 'effectAmplifier'
     *
     * @param value New value for field 'effectAmplifier'
     */
    public void setEffectAmplifier(byte value) {
        this.handle.getBytes().write(0, value);
    }

    /**
     * Retrieves the value of field 'effectDurationTicks'
     *
     * @return 'effectDurationTicks'
     */
    public int getEffectDurationTicks() {
        return this.handle.getIntegers().read(1);
    }

    /**
     * Sets the value of field 'effectDurationTicks'
     *
     * @param value New value for field 'effectDurationTicks'
     */
    public void setEffectDurationTicks(int value) {
        this.handle.getIntegers().write(1, value);
    }

    /**
     * Retrieves a bitmask for different flags of this effect
     *
     * @return 'flags'
     */
    public byte getFlags() {
        return this.handle.getBytes().read(1);
    }

    /**
     * Sets a bitmask for different flags of this effect
     *
     * @param value New value for field 'flags'
     */
    public void setFlags(byte value) {
        this.handle.getBytes().write(1, value);
    }

    @UtilityMethod
    public boolean isAmbient() {
        return (this.getFlags() & FLAG_AMBIENT) > 0;
    }

    @UtilityMethod
    public void setAmbient(boolean ambient) {
        if (ambient) {
            this.setFlags((byte) (this.getFlags() | FLAG_AMBIENT));
        } else {
            this.setFlags((byte) (this.getFlags() & ~FLAG_AMBIENT));
        }
    }

    @UtilityMethod
    public boolean isShowParticles() {
        return (this.getFlags() & FLAG_SHOW_PARTICLE) > 0;
    }

    @UtilityMethod
    public void setShowParticles(boolean showParticles) {
        if (showParticles) {
            this.setFlags((byte) (this.getFlags() | FLAG_SHOW_PARTICLE));
        } else {
            this.setFlags((byte) (this.getFlags() & ~FLAG_SHOW_PARTICLE));
        }
    }

    @UtilityMethod
    public boolean isShowIcon() {
        return (this.getFlags() & FLAG_SHOW_ICON) > 0;
    }

    @UtilityMethod
    public void setShowIcon(boolean showIcon) {
        if (showIcon) {
            this.setFlags((byte) (this.getFlags() | FLAG_SHOW_ICON));
        } else {
            this.setFlags((byte) (this.getFlags() & ~FLAG_SHOW_ICON));
        }
    }

    /**
     * Retrieves the value of field 'factorData'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @return 'factorData'
     */
    @Deprecated
    public InternalStructure getFactorDataInternal() {
        return this.handle.getStructures().read(1);
    }

    /**
     * Sets the value of field 'factorData'
     * ProtocolLib currently does not provide a wrapper for this type. Access to this type is only provided by an InternalStructure
     *
     * @param value New value for field 'factorData'
     */
    @Deprecated
    public void setFactorDataInternal(InternalStructure value) {
        this.handle.getStructures().write(1, value);
    }

    /**
     * Retrieves the value of field 'factorData'
     *
     * @return 'factorData'
     */
    @Nullable
    public WrappedFactorData getFactorData() {
        return this.handle.getModifier().withType(WrappedFactorData.HANDLE_TYPE, WrappedFactorData.CONVERTER).read(0);
    }

    /**
     * Sets the value of field 'factorData'
     *
     * @param value New value for field 'factorData'
     */
    public void setFactorData(@Nullable WrappedFactorData value) {
        this.handle.getModifier().withType(WrappedFactorData.HANDLE_TYPE, WrappedFactorData.CONVERTER).write(0, value);
    }

    public static class WrappedFactorData {
        private static final Class<?> HANDLE_TYPE = MinecraftReflection.getMinecraftClass("world.effect.MobEffectInstance$FactorData", "world.effect.MobEffect$a");
        private static final EquivalentConverter<WrappedFactorData> CONVERTER = Converters.ignoreNull(AutoWrapper.wrap(WrappedFactorData.class, HANDLE_TYPE));

        private int paddingDuration;
        private float factorStart;
        private float factorTarget;
        private float factorCurrent;
        private int ticksActive;
        private float factorPreviousFrame;
        private boolean hadEffectLastTick;

        public int getPaddingDuration() {
            return paddingDuration;
        }

        public void setPaddingDuration(int paddingDuration) {
            this.paddingDuration = paddingDuration;
        }

        public float getFactorStart() {
            return factorStart;
        }

        public void setFactorStart(float factorStart) {
            this.factorStart = factorStart;
        }

        public float getFactorTarget() {
            return factorTarget;
        }

        public void setFactorTarget(float factorTarget) {
            this.factorTarget = factorTarget;
        }

        public float getFactorCurrent() {
            return factorCurrent;
        }

        public void setFactorCurrent(float factorCurrent) {
            this.factorCurrent = factorCurrent;
        }

        public int getTicksActive() {
            return ticksActive;
        }

        public void setTicksActive(int ticksActive) {
            this.ticksActive = ticksActive;
        }

        public float getFactorPreviousFrame() {
            return factorPreviousFrame;
        }

        public void setFactorPreviousFrame(float factorPreviousFrame) {
            this.factorPreviousFrame = factorPreviousFrame;
        }

        public boolean isHadEffectLastTick() {
            return hadEffectLastTick;
        }

        public void setHadEffectLastTick(boolean hadEffectLastTick) {
            this.hadEffectLastTick = hadEffectLastTick;
        }

        @Override
        public String toString() {
            return "WrappedFactorData{" +
                    "paddingDuration=" + paddingDuration +
                    ", factorStart=" + factorStart +
                    ", factorTarget=" + factorTarget +
                    ", factorCurrent=" + factorCurrent +
                    ", ticksActive=" + ticksActive +
                    ", factorPreviousFrame=" + factorPreviousFrame +
                    ", hadEffectLastTick=" + hadEffectLastTick +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrappedFactorData that = (WrappedFactorData) o;

            if (paddingDuration != that.paddingDuration) return false;
            if (Float.compare(that.factorStart, factorStart) != 0) return false;
            if (Float.compare(that.factorTarget, factorTarget) != 0) return false;
            if (Float.compare(that.factorCurrent, factorCurrent) != 0) return false;
            if (ticksActive != that.ticksActive) return false;
            if (Float.compare(that.factorPreviousFrame, factorPreviousFrame) != 0) return false;
            return hadEffectLastTick == that.hadEffectLastTick;
        }

        @Override
        public int hashCode() {
            int result = paddingDuration;
            result = 31 * result + (factorStart != +0.0f ? Float.floatToIntBits(factorStart) : 0);
            result = 31 * result + (factorTarget != +0.0f ? Float.floatToIntBits(factorTarget) : 0);
            result = 31 * result + (factorCurrent != +0.0f ? Float.floatToIntBits(factorCurrent) : 0);
            result = 31 * result + ticksActive;
            result = 31 * result + (factorPreviousFrame != +0.0f ? Float.floatToIntBits(factorPreviousFrame) : 0);
            result = 31 * result + (hadEffectLastTick ? 1 : 0);
            return result;
        }
    }
}
