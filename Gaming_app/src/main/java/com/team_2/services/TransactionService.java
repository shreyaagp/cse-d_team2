package com.team_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.team_2.models.Transaction;
import com.team_2.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}
