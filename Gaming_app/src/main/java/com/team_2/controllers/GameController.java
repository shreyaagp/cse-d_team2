package com.team_2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team_2.models.Game;
import com.team_2.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    // ✅ Get all games
    @GetMapping
    public List<Game> getGames() {
        logger.info("Received request: GET /games");
        return gameService.getAllGames();
    }

    // ✅ Get game by ID
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable String id) {
        logger.info("Received request: GET /games/{}", id);
        return gameService.getGameById(id);
    }

    // ✅ Add new game
    @PostMapping
    public Game addGame(@RequestBody Game game) {
        logger.info("Received request: POST /games");
        return gameService.addGame(game);
    }

    // ✅ Update game
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable String id, @RequestBody Game game) {
        logger.info("Received request: PUT /games/{}", id);
        return gameService.updateGame(id, game);
    }

    // ✅ Delete game
    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable String id) {
        logger.info("Received request: DELETE /games/{}", id);
        gameService.deleteGame(id);
        return "Game with ID " + id + " deleted successfully!";
    }
}
