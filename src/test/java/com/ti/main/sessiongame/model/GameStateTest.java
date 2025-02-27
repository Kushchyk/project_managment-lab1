package com.ti.main.sessiongame.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameStateTest {
    private GameState gameState;

    @Before
    public void setUp() {
        gameState = new GameState();
    }

    @Test
    public void testInitialState() {
        Assert.assertEquals(40, gameState.getStressLevel());
        Assert.assertEquals(50, gameState.getCoffeeLevel());
        Assert.assertEquals(50, gameState.getSleepLevel());
        Assert.assertEquals(0, gameState.getKnowledgeLevel());
        Assert.assertFalse(gameState.isPanic());
        Assert.assertFalse(gameState.isExpelled());
    }

    @Test
    public void testStudyIncreasesStressAndKnowledge() {
        gameState.study();
        Assert.assertEquals(70, gameState.getStressLevel());
        Assert.assertEquals(40, gameState.getSleepLevel());
        Assert.assertEquals(10, gameState.getKnowledgeLevel());
    }

    @Test
    public void testDrinkCoffeeReducesStressAndIncreasesCoffeeLevel() {
        gameState.drinkCoffee();
        Assert.assertEquals(70, gameState.getCoffeeLevel());
        Assert.assertEquals(35, gameState.getSleepLevel());
        Assert.assertEquals(40, gameState.getStressLevel());
    }

    @Test
    public void testSleepReducesStressAndIncreasesSleepLevel() {
        gameState.sleep();
        Assert.assertEquals(30, gameState.getStressLevel());
        Assert.assertEquals(80, gameState.getSleepLevel());
        Assert.assertEquals(-5, gameState.getKnowledgeLevel());
    }

    @Test
    public void testPanicWhenStressIs100() {
        gameState.setStressLevel(90);
        gameState.study();
        Assert.assertTrue(gameState.isPanic());
    }

    @Test
    public void testExpelledWhenCoffeeOrSleepReachesZero() {
        gameState.setSleepLevel(5);
        gameState.study();
        Assert.assertTrue(gameState.isExpelled());
    }
}
