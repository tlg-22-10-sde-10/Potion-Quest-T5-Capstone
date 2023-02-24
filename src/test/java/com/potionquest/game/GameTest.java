package com.potionquest.game;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Game gameInstance = null;


    @Test
    void createGameInstance() throws IOException {

       gameInstance = Game.createGameInstance();

        String  expectedName= "Cindy";
        String  actualName = gameInstance.getPlayer().getName();

        String  expectedLocation= "Whitby Village";
        String  actualLocation = gameInstance.getPlayer().getCurrentLocation().getName();

        int expectedPlayerHealth = 100;
        int actualPlayerHealth = gameInstance.getPlayer().getHealth();

        assertEquals(expectedName,actualName);
        assertEquals(expectedLocation,actualLocation);
        assertEquals(expectedPlayerHealth,actualPlayerHealth);
    }
}