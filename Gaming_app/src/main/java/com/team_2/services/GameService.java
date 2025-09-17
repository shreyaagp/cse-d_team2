package com.team_2.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.team_2.models.Game;
import com.team_2.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    public Game addGame(Game game) {
        return gameRepo.save(game);
    }
}
