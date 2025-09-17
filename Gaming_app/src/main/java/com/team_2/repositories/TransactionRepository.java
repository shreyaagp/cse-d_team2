package com.team_2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.team_2.models.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {}
