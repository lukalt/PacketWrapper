package com.comphenix.packetwrapper.wrappers.login.serverbound;

import com.comphenix.packetwrapper.BaseTestInitialization;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lukas Alt
 * @since 04.02.2024
 */
@ExtendWith(BaseTestInitialization.class)
class WrapperLoginClientStartTest {
    @Test
    void testModifyName() {
        WrapperLoginClientStart dummy = new WrapperLoginClientStart();
        dummy.setName("abcd");
        assertEquals("abcd", dummy.getName());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testModifyProfileId() {
        UUID dummyId = UUID.randomUUID();
        WrapperLoginClientStart dummy = new WrapperLoginClientStart();
        dummy.setProfileId(dummyId);
        assertEquals(dummyId, dummy.getProfileIdDirectly());
        dummy.setProfileId(dummyId);
        assertTrue(dummy.getProfileId().isPresent());
        assertEquals(dummyId, dummy.getProfileId().get());
    }

}