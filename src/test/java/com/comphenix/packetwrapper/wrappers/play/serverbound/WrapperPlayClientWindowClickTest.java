package com.comphenix.packetwrapper.wrappers.play.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lukas Alt
 * @since 08.05.2023
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayClientWindowClickTest {

    @Test
    public void testChangedSlots() {
        WrapperPlayClientWindowClick packet = new WrapperPlayClientWindowClick();
        Int2ObjectMap<ItemStack> map = packet.getChangedSlots();
        map.put(1, new ItemStack(Material.AIR));
        map.put(3, new ItemStack(Material.STONE));
        packet.setChangedSlots(map);

        packet.setClickType(WrapperPlayClientWindowClick.WrappedClickType.SWAP);
        assertEquals(WrapperPlayClientWindowClick.WrappedClickType.SWAP, packet.getClickType());

    }
}