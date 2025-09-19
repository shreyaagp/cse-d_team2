package com.team_2.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team_2.exceptions.BadRequestException;
import com.team_2.exceptions.ResourceNotFoundException;
import com.team_2.models.Transaction;
import com.team_2.repositories.TransactionRepository;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepo;

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        logger.info("Fetching all transactions from DB");
        List<Transaction> transactions = transactionRepo.findAll();
        if (transactions.isEmpty()) {
            logger.error("No transactions found");
            throw new ResourceNotFoundException("No transactions found in database");
        }
        return transactions;
    }

    // Get transaction by ID
    public Transaction getTransactionById(String id) {
        logger.info("Fetching transaction with ID: {}", id);
        return transactionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with ID " + id + " not found"));
    }

    // Add new transaction
    public Transaction addTransaction(Transaction transaction) {
        if (transaction == null || transaction.getMemberId() == null || transaction.getMemberId().trim().isEmpty()
            || transaction.getGameId() == null || transaction.getGameId().trim().isEmpty()) {
            logger.error("Invalid transaction data");
            throw new BadRequestException("Transaction must have valid memberId and gameId");
        }
        logger.info("Adding transaction for memberId: {}, gameId: {}", transaction.getMemberId(), transaction.getGameId());
        return transactionRepo.save(transaction);
    }

    // Update transaction
    public Transaction updateTransaction(String id, Transaction updatedTransaction) {
        logger.info("Updating transaction with ID: {}", id);
        Transaction existingTransaction = transactionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with ID " + id + " not found"));

        if (updatedTransaction.getMemberId() != null) {
            existingTransaction.setMemberId(updatedTransaction.getMemberId());
        }
        if (updatedTransaction.getGameId() != null) {
            existingTransaction.setGameId(updatedTransaction.getGameId());
        }
        if (updatedTransaction.getAmount() > 0) {
            existingTransaction.setAmount(updatedTransaction.getAmount());
        }
        if (updatedTransaction.getDate() != null) {
            existingTransaction.setDate(updatedTransaction.getDate());
        }
        if (updatedTransaction.getDuration() > 0) {
            existingTransaction.setDuration(updatedTransaction.getDuration());
        }
        if (updatedTransaction.getPlayers() > 0) {
            existingTransaction.setPlayers(updatedTransaction.getPlayers());
        }
        existingTransaction.setPlayersMultiple(updatedTransaction.isPlayersMultiple());
        if (updatedTransaction.getStatus() != null) {
            existingTransaction.setStatus(updatedTransaction.getStatus());
        }

        return transactionRepo.save(existingTransaction);
    }

    // Delete transaction
    public void deleteTransaction(String id) {
        logger.info("Deleting transaction with ID: {}", id);
        Transaction transaction = transactionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with ID " + id + " not found"));
        transactionRepo.delete(transaction);
        logger.info("Transaction deleted successfully with ID: {}", id);
    }
}
