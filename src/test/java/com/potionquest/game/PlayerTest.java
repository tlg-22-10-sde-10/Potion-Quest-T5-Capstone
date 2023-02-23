package com.potionquest.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeEach
    void setUp() {
        Player testUser = new Player("testUser", 100,
                new ArrayList<>(5), new HashMap<>(), new Location());
    }

    @Test
    void getName() {
        Player testUser = new Player("testUser", 100,
                new ArrayList<>(5), new HashMap<>(), new Location());
        assertEquals("testUser",testUser.getName());
    }



}