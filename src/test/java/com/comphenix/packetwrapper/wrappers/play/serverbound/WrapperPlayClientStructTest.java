package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.block.structure.UsageMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 21.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientStructTest {
    @Test
    public void test() {
        WrapperPlayClientStruct dummy = new WrapperPlayClientStruct();
        dummy.setRotation(StructureRotation.CLOCKWISE_180);
        dummy.setMirror(Mirror.FRONT_BACK);
        dummy.setMode(UsageMode.CORNER);
        dummy.setUpdateType(WrapperPlayClientStruct.UpdateType.UPDATE_DATA);

        assertEquals(StructureRotation.CLOCKWISE_180, dummy.getRotation());
        assertEquals(Mirror.FRONT_BACK, dummy.getMirror());
        assertEquals(UsageMode.CORNER, dummy.getMode());
        assertEquals(WrapperPlayClientStruct.UpdateType.UPDATE_DATA, dummy.getUpdateType());
    }
}