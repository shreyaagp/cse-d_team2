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

import com.team_2.models.Transaction;
import com.team_2.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransactions() {
        logger.info("Received request to fetch all transactions");
        List<Transaction> transactions = transactionService.getAllTransactions();
        logger.debug("Fetched {} transactions from service", transactions.size());
        return transactions;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        logger.info("Received request to add new transaction for memberId: {}", transaction.getMemberId());
        Transaction savedTransaction = transactionService.addTransaction(transaction);
        logger.info("Transaction saved successfully with id: {}", savedTransaction.getId());
        return savedTransaction;
    }
}
