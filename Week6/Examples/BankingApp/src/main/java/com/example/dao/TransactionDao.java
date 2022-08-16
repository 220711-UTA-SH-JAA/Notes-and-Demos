package com.example.dao;

import java.util.List;

import com.example.models.Transaction;

public interface TransactionDao {
	
	void createTransaction(Transaction t);
	
	Transaction readTransactionById(int id);
	
	List<Transaction> readAllTransactions();

}
