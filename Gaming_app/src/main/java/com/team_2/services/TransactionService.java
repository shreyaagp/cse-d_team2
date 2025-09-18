package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.models.Transaction;
import com.team_2.repositories.TransactionRepository;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepo;

    public List<Transaction> getAllTransactions() {
        logger.info("Fetching all transactions from database");
        List<Transaction> transactions = transactionRepo.findAll();
        logger.info("Retrieved {} transactions from database", transactions.size());
        return transactions;
    }

    public Transaction addTransaction(Transaction transaction) {
        logger.info("Attempting to add new transaction for memberId: {}", transaction.getMemberId());
        Transaction savedTransaction = transactionRepo.save(transaction);
        logger.info("Transaction added successfully with ID: {}", savedTransaction.getId());
        return savedTransaction;
    }
}
