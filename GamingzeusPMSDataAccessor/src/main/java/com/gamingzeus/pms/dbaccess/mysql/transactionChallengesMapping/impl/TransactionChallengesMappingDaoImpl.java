package com.gamingzeus.pms.dbaccess.mysql.transactionChallengesMapping.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gamingzeus.pms.core.entity.TransactionChallengesMapping;
import com.gamingzeus.pms.dbaccess.mysql.transactionChallengesMapping.ITransactionChallengesMappingDao;

@Repository("transactionChallengesMappingDao")
public class TransactionChallengesMappingDaoImpl implements
		ITransactionChallengesMappingDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public TransactionChallengesMapping insertTransactionChallengesMapping(
			TransactionChallengesMapping transactionChallengesMapping) {
		return (TransactionChallengesMapping) sessionFactory.getCurrentSession().merge(
				transactionChallengesMapping);
	}

	@Override
	public TransactionChallengesMapping fetchTransactionByChallengeId(
			String challengeId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Transaction where challengeId=:challengeId");
		query.setParameter("challengeId", challengeId);
		return (TransactionChallengesMapping) query.uniqueResult();
	}

	@Override
	public TransactionChallengesMapping fetchTransactionByTransactionId(
			String transactionId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Transaction where transactionId=:transactionId");
		query.setParameter("transactionId", transactionId);
		return (TransactionChallengesMapping) query.uniqueResult();
	}

}
