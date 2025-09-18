package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.models.Game;
import com.team_2.repositories.GameRepository;

@Service
public class GameService {

    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private GameRepository gameRepo;

    public List<Game> getAllGames() {
        logger.info("Fetching all games from database");
        List<Game> games = gameRepo.findAll();
        logger.info("Retrieved {} games from database", games.size());
        return games;
    }

    public Game addGame(Game game) {
        logger.info("Attempting to add new game: {}", game.getName());
        Game savedGame = gameRepo.save(game);
        logger.info("Game added successfully with ID: {}", savedGame.getId());
        return savedGame;
    }
}
