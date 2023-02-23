package com.potionquest.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void createGameInstance() {

       Game gameInstance = new Game(new Player("Rupesh",100,null,null,
                new Location("Boston",null,null)),null,null,null,null,null
        );

        String  expectedName= "Rupesh";
        String  actualName = gameInstance.getPlayer().getName();

        String  expectedLocation= "Boston";
        String  actualLocation = gameInstance.getPlayer().getCurrentLocation().getName();

        int expectedPlayerHealth = 100;
        int actualPlayerHealth = gameInstance.getPlayer().getHealth();

        assertEquals(expectedName,actualName);
        assertEquals(expectedLocation,actualLocation);
        assertEquals(expectedPlayerHealth,actualPlayerHealth);
    }
}