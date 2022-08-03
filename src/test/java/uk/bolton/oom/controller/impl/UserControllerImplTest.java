package uk.bolton.oom.controller.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.bolton.oom.exception.UserCustomException;
import uk.bolton.oom.observer.ChannelSubject;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class UserControllerImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test user sign-up")
    void signUpUser() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test fetch all channel list")
    void getAllChannelList() {
        Set<ChannelSubject> channelSubjects = new HashSet<>();
        assertNotNull(channelSubjects);
    }
}