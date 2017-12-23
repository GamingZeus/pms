package com.gamingzeus.pms.dbaccess.mysql.transaction.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gamingzeus.pms.core.entity.Transaction;
import com.gamingzeus.pms.dbaccess.mysql.transaction.ITransactionDao;

@Repository("transactionDao")
public class TransactionDaoImpl implements ITransactionDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Transaction insertTransaction(Transaction transaction) {
		return (Transaction) sessionFactory.getCurrentSession().merge(
				transaction);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> fetchPaginatedTransaction(String userId,
			int start, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Transaction where userId=:userId");
		query.setParameter("userId", userId);
		query.setFetchSize(pageSize);
		query.setFirstResult(start * pageSize);
		return query.list();
	}

	@Override
	public Transaction fetchTransactionById(String transactionId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Transaction where id=:id");
		query.setParameter("id", transactionId);
		return (Transaction) query.uniqueResult();
	}

}
