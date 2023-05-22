package com.comphenix.packetwrapper.wrappers.play.clientbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import com.comphenix.protocol.events.PacketContainer;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @since 22.05.2023
 * @author Lukas Alt
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperPlayServerBundleTest {
    @Test
    public void test() {
        WrapperPlayServerBundle dummy = new WrapperPlayServerBundle();
        WrapperPlayServerEntityDestroy destroy = new WrapperPlayServerEntityDestroy();
        IntList value = new IntArrayList();
        value.add(1);
        destroy.setEntityIds(value);
        List<PacketContainer> packets = new ArrayList<>(Collections.singletonList(destroy.getHandle()));
        dummy.setPackets(packets);

        List<PacketContainer> out = new ArrayList<>();
        for (PacketContainer packet : dummy.getPackets()) {
            out.add(packet);
        }
        assertEquals(packets.size(), out.size());
        assertEquals(packets.get(0).getHandle(), out.get(0).getHandle());
    }
}