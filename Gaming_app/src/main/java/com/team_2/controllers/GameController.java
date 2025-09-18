package com.team_2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
    public List<Game> getGames() {
        logger.info("Received request to fetch all games");
        List<Game> games = gameService.getAllGames();
        logger.info("Returning {} games", games.size());
        return games;
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {
        logger.info("Received request to add a new game: {}", game.getName());
        Game savedGame = gameService.addGame(game);
        logger.info("Game added successfully with ID: {}", savedGame.getId());
        return savedGame;
    }
}
