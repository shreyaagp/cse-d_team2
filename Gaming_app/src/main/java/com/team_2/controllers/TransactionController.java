package com.team_2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        logger.info("API Call: GET /transactions");
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        logger.info("API Call: GET /transactions/{}", id);
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    // Add new transaction
    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        logger.info("API Call: POST /transactions");
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }

    // Update transaction
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String id, @RequestBody Transaction transaction) {
        logger.info("API Call: PUT /transactions/{}", id);
        return ResponseEntity.ok(transactionService.updateTransaction(id, transaction));
    }

    // Delete transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String id) {
        logger.info("API Call: DELETE /transactions/{}", id);
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction with ID " + id + " deleted successfully");
    }
}
