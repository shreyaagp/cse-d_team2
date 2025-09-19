package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.exceptions.BadRequestException;
import com.team_2.exceptions.ResourceNotFoundException;
import com.team_2.models.Game;
import com.team_2.repositories.GameRepository;

@Service
public class GameService {

    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private GameRepository gameRepo;

    // ✅ Get all games
    public List<Game> getAllGames() {
        logger.info("Fetching all games from database");
        List<Game> games = gameRepo.findAll();
        if (games.isEmpty()) {
            logger.warn("No games found in database");
            throw new ResourceNotFoundException("No games found in database");
        }
        logger.info("Retrieved {} games", games.size());
        return games;
    }

    // ✅ Get game by ID
    public Game getGameById(String id) {
        logger.info("Fetching game with ID: {}", id);
        return gameRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game with ID " + id + " not found"));
    }

    // ✅ Add new game
    public Game addGame(Game game) {
        if (game == null || game.getName() == null || game.getName().trim().isEmpty()) {
            logger.error("Invalid game data provided");
            throw new BadRequestException("Game name must not be empty");
        }
        logger.info("Adding new game: {}", game.getName());
        Game savedGame = gameRepo.save(game);
        logger.info("Game added successfully with ID: {}", savedGame.getId());
        return savedGame;
    }

    // ✅ Update game
    public Game updateGame(String id, Game updatedGame) {
        logger.info("Updating game with ID: {}", id);
        Game existingGame = gameRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game with ID " + id + " not found"));

        if (updatedGame.getName() != null && !updatedGame.getName().trim().isEmpty()) {
            existingGame.setName(updatedGame.getName());
        }
        if (updatedGame.getPrice() > 0) {
            existingGame.setPrice(updatedGame.getPrice());
        }
        if (updatedGame.getDescription() != null) {
            existingGame.setDescription(updatedGame.getDescription());
        }
        if (updatedGame.getDuration() > 0) {
            existingGame.setDuration(updatedGame.getDuration());
        }
        if (updatedGame.getMinPlayers() > 0) {
            existingGame.setMinPlayers(updatedGame.getMinPlayers());
        }
        if (updatedGame.getMaxPlayers() > 0) {
            existingGame.setMaxPlayers(updatedGame.getMaxPlayers());
        }
        existingGame.setPlayersMultiple(updatedGame.isPlayersMultiple());
        if (updatedGame.getStatus() != null) {
            existingGame.setStatus(updatedGame.getStatus());
        }

        Game savedGame = gameRepo.save(existingGame);
        logger.info("Game updated successfully with ID: {}", savedGame.getId());
        return savedGame;
    }

    // ✅ Delete game
    public void deleteGame(String id) {
        logger.info("Deleting game with ID: {}", id);
        if (!gameRepo.existsById(id)) {
            logger.error("Game with ID {} not found", id);
            throw new ResourceNotFoundException("Game with ID " + id + " not found");
        }
        gameRepo.deleteById(id);
        logger.info("Game deleted successfully with ID: {}", id);
    }
}
