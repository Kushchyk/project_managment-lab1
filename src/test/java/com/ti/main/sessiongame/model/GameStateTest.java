package com.ti.main.sessiongame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStateTest {
    final private GameState gameState = new GameState();

    @Test
    public void testInitialState() {
        Assertions.assertEquals(50, gameState.getStressLevel());
        Assertions.assertEquals(50, gameState.getCoffeeLevel());
        Assertions.assertEquals(50, gameState.getSleepLevel());
        Assertions.assertEquals(0, gameState.getKnowledgeLevel());
        Assertions.assertFalse(gameState.isPanic());
        Assertions.assertFalse(gameState.isExpelled());
    }

    @Test
    public void testStudy() {
        gameState.study();
        Assertions.assertEquals(70, gameState.getStressLevel());
        Assertions.assertEquals(40, gameState.getSleepLevel());
        Assertions.assertEquals(10, gameState.getKnowledgeLevel());
    }

    @Test
    public void testDrinkCoffee() {
        gameState.drinkCoffee();
        Assertions.assertEquals(70, gameState.getCoffeeLevel());
        Assertions.assertEquals(35, gameState.getSleepLevel());
        Assertions.assertEquals(40, gameState.getStressLevel());
    }

    @Test
    public void testSleep() {
        gameState.sleep();
        Assertions.assertEquals(30, gameState.getStressLevel());
        Assertions.assertEquals(80, gameState.getSleepLevel());
        Assertions.assertEquals(-5, gameState.getKnowledgeLevel());
    }

    @Test
    public void testPanic() {
        gameState.setStressLevel(90);
        gameState.study();
        Assertions.assertTrue(gameState.isPanic());
    }

    @Test
    public void testExpelled() {
        gameState.setSleepLevel(5);
        gameState.study();
        Assertions.assertTrue(gameState.isExpelled());
    }
}
