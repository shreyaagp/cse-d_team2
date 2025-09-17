package com.team_2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.team_2.models.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {}
