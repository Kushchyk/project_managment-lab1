package com.ti.main.sessiongame.model;

public class GameState {
    private int stressLevel;
    private int coffeeLevel;
    private int sleepLevel;
    private int knowledgeLevel;
    private boolean isPanic;
    private boolean isExpelled;

    public GameState() {
        stressLevel = 50;
        coffeeLevel = 50;
        sleepLevel = 50;
        knowledgeLevel = 0;
        isPanic = false;
        isExpelled = false;
    }

    // Геттери та сеттери
    public int getStressLevel() { return stressLevel; }
    public void setStressLevel(int stressLevel) { this.stressLevel = stressLevel; }

    public int getCoffeeLevel() { return coffeeLevel; }
    public void setCoffeeLevel(int coffeeLevel) { this.coffeeLevel = coffeeLevel; }

    public int getSleepLevel() { return sleepLevel; }
    public void setSleepLevel(int sleepLevel) { this.sleepLevel = sleepLevel; }

    public int getKnowledgeLevel() { return knowledgeLevel; }
    public void setKnowledgeLevel(int knowledgeLevel) { this.knowledgeLevel = knowledgeLevel; }

    public boolean isPanic() { return isPanic; }
    public void setPanic(boolean panic) { isPanic = panic; }

    public boolean isExpelled() { return isExpelled; }
    public void setExpelled(boolean expelled) { isExpelled = expelled; }

    // Логіка гри
    public void study() {
        if (isPanic || isExpelled) return;
        knowledgeLevel += 10;
        stressLevel += 20;
        sleepLevel -= 10;
        checkStatus();
    }

    public void drinkCoffee() {
        if (isPanic || isExpelled) return;
        coffeeLevel += 20;
        sleepLevel -= 15;
        stressLevel -= 10;
        checkStatus();
    }

    public void sleep() {
        if (isPanic || isExpelled) return;
        sleepLevel += 30;
        stressLevel -= 20;
        knowledgeLevel -= 5;
        checkStatus();
    }

    private void checkStatus() {
        if (stressLevel >= 100) {
            isPanic = true;
        }
        if (coffeeLevel <= 0 || sleepLevel <= 0) {
            isExpelled = true;
        }
    }

}