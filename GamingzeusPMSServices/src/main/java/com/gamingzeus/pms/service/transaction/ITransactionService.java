package com.gamingzeus.pms.service.transaction;

import java.util.List;

import com.gamingzeus.pms.core.entity.Transaction;

public interface ITransactionService {

	Transaction insertTransaction(Transaction transaction);
	List<Transaction> fetchPaginatedTransaction(String userId, int start, int pageSize);
	Transaction fetchTransactionById(String transactionId);
}
