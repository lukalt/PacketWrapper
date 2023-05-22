package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.packetwrapper.wrappers.play.clientbound.WrapperPlayServerBoss;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Constructor;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 08.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerBossTest {

    private WrapperPlayServerBoss makeDummy() {
        WrapperPlayServerBoss dummy = new WrapperPlayServerBoss();
        UUID value = UUID.randomUUID();
        dummy.setId(value);
        assertEquals(value, dummy.getId());
        return dummy;
    }
    @Test
    public void testAdd() {
        WrapperPlayServerBoss dummy = makeDummy();
        dummy.setOperation(WrapperPlayServerBoss.WrappedBossBarAddOperation.create(
                WrappedChatComponent.fromText("Test"),
                0.5F,
                BarColor.BLUE,
                BarStyle.SEGMENTED_6,
                true,
                false,
                true));
        WrapperPlayServerBoss.WrappedBossBarAddOperation op = (WrapperPlayServerBoss.WrappedBossBarAddOperation) dummy.getOperation();
        assertEquals(WrappedChatComponent.fromText("Test"), op.getName());
        assertEquals(0.5F, op.getProgress());
        assertEquals(BarColor.BLUE, op.getColor());
        assertEquals(BarStyle.SEGMENTED_6, op.getOverlay());
        assertTrue(op.isDarkenScreen());
        assertFalse(op.isPlayMusic());
        assertTrue(op.isCreateWorldFog());
        assertEquals(WrapperPlayServerBoss.OperationType.ADD, dummy.getOperation().getType());
    }

    @Test
    public void testRemove() {
        WrapperPlayServerBoss dummy = makeDummy();
        dummy.setOperation(WrapperPlayServerBoss.WrappedBossBarRemoveOperation.create());
        assertEquals(WrapperPlayServerBoss.OperationType.REMOVE, dummy.getOperation().getType());
    }

    @Test
    public void testUpdateName() {
        WrapperPlayServerBoss dummy = makeDummy();
        dummy.setOperation(WrapperPlayServerBoss.WrappedBossBarUpdateNameOperation.create(WrappedChatComponent.fromText("Test")));
        assertEquals(WrapperPlayServerBoss.OperationType.UPDATE_NAME, dummy.getOperation().getType());
        assertEquals(WrappedChatComponent.fromText("Test"), ((WrapperPlayServerBoss.WrappedBossBarUpdateNameOperation) dummy.getOperation()).getName());
    }

    @Test
    public void testUpdateProgress() {
        WrapperPlayServerBoss dummy = makeDummy();
        dummy.setOperation(WrapperPlayServerBoss.WrappedBossBarProgressOperation.create(0.5F));
        assertEquals(WrapperPlayServerBoss.OperationType.UPDATE_PROGRESS, dummy.getOperation().getType());
        assertEquals(0.5F, ((WrapperPlayServerBoss.WrappedBossBarProgressOperation) dummy.getOperation()).getProgress());
    }

    @Test
    public void testUpdateStyle() {
        WrapperPlayServerBoss dummy = makeDummy();
        dummy.setOperation(WrapperPlayServerBoss.WrappedBossBarUpdateStyleOperation.create(BarColor.BLUE, BarStyle.SEGMENTED_10));
        assertEquals(WrapperPlayServerBoss.OperationType.UPDATE_STYLE, dummy.getOperation().getType());
        WrapperPlayServerBoss.WrappedBossBarUpdateStyleOperation op = (WrapperPlayServerBoss.WrappedBossBarUpdateStyleOperation) dummy.getOperation();
        assertEquals(BarColor.BLUE, op.getColor());
        assertEquals(BarStyle.SEGMENTED_10, op.getOverlay());
    }

    @Test
    public void testUpdateProperties() {
        WrapperPlayServerBoss dummy = makeDummy();
        dummy.setOperation(WrapperPlayServerBoss.WrappedBossBarUpdatePropertiesOperation.create(true, false, true));
        assertEquals(WrapperPlayServerBoss.OperationType.UPDATE_PROPERTIES, dummy.getOperation().getType());
        WrapperPlayServerBoss.WrappedBossBarUpdatePropertiesOperation op = (WrapperPlayServerBoss.WrappedBossBarUpdatePropertiesOperation) dummy.getOperation();
        assertTrue(op.isDarkenScreen());
        assertFalse(op.isPlayMusic());
        assertTrue(op.isCreateWorldFog());
    }

}