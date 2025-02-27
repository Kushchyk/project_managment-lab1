package com.ti.main.sessiongame.controller;

import com.ti.main.sessiongame.model.GameState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        // Початковий стан тесту
    }

    @Test
    public void testGetStatus() throws Exception {
        mockMvc.perform(get("/game/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stressLevel", is(50)))
                .andExpect(jsonPath("$.coffeeLevel", is(50)))
                .andExpect(jsonPath("$.sleepLevel", is(50)))
                .andExpect(jsonPath("$.knowledgeLevel", is(0)))
                .andExpect(jsonPath("$.panic", is(false)))
                .andExpect(jsonPath("$.expelled", is(false)));
    }

    @Test
    public void testStudyEndpoint() throws Exception {
        mockMvc.perform(post("/game/study"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stressLevel", is(70)))
                .andExpect(jsonPath("$.sleepLevel", is(40)))
                .andExpect(jsonPath("$.knowledgeLevel", is(10)));
    }

    @Test
    public void testDrinkCoffeeEndpoint() throws Exception {
        mockMvc.perform(post("/game/drinkCoffee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coffeeLevel", is(70)))
                .andExpect(jsonPath("$.stressLevel", is(40)))
                .andExpect(jsonPath("$.sleepLevel", is(35)));
    }

    @Test
    public void testSleepEndpoint() throws Exception {
        mockMvc.perform(post("/game/sleep"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stressLevel", is(30)))
                .andExpect(jsonPath("$.sleepLevel", is(80)))
                .andExpect(jsonPath("$.knowledgeLevel", is(-5)));
    }

    @Test
    public void testResetEndpoint() throws Exception {
        mockMvc.perform(post("/game/reset"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stressLevel", is(50)))
                .andExpect(jsonPath("$.coffeeLevel", is(50)))
                .andExpect(jsonPath("$.sleepLevel", is(50)))
                .andExpect(jsonPath("$.knowledgeLevel", is(0)))
                .andExpect(jsonPath("$.panic", is(false)))
                .andExpect(jsonPath("$.expelled", is(false)));
    }
}
