package com.gamingzeus.pms.dbaccess.mysql.transaction;

import java.util.List;

import com.gamingzeus.pms.core.entity.Transaction;

public interface ITransactionDao {

	Transaction insertTransaction(Transaction transaction);
	List<Transaction> fetchPaginatedTransaction(String userId, int start, int pageSize);
	Transaction fetchTransactionById(String transactionId);
}
