package com.gamingzeus.pms.service.transaction.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingzeus.pms.core.entity.Transaction;
import com.gamingzeus.pms.dbaccess.mysql.transaction.ITransactionDao;
import com.gamingzeus.pms.service.transaction.ITransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private ITransactionDao transactionDao;

	@Override
	@Transactional
	public Transaction insertTransaction(Transaction transaction) {
		return transactionDao.insertTransaction(transaction);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Transaction> fetchPaginatedTransaction(String userId,
			int start, int pageSize) {
		return transactionDao.fetchPaginatedTransaction(userId, start, pageSize);
	}

	@Override
	@Transactional(readOnly=true)
	public Transaction fetchTransactionById(String transactionId) {
		return transactionDao.fetchTransactionById(transactionId);
	}

}
