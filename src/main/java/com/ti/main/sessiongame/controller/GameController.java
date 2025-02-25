package com.ti.main.sessiongame.controller;

import com.ti.main.sessiongame.model.GameState;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    private GameState gameState = new GameState();

    @GetMapping("/status")
    public GameState getStatus() {
        return gameState;
    }

    @PostMapping("/study")
    public GameState study() {
        gameState.study();
        return gameState;
    }

    @PostMapping("/drinkCoffee")
    public GameState drinkCoffee() {
        gameState.drinkCoffee();
        return gameState;
    }

    @PostMapping("/sleep")
    public GameState sleep() {
        gameState.sleep();
        return gameState;
    }

    @PostMapping("/reset")
    public GameState reset() {
        gameState = new GameState();
        return gameState;
    }
}