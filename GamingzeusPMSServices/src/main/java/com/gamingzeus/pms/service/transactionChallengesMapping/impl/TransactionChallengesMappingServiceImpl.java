package com.gamingzeus.pms.service.transactionChallengesMapping.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingzeus.pms.core.entity.TransactionChallengesMapping;
import com.gamingzeus.pms.dbaccess.mysql.transactionChallengesMapping.ITransactionChallengesMappingDao;
import com.gamingzeus.pms.service.transactionChallengesMapping.ITransactionChallengesMappingService;

@Service("transactionChallengesMappingService")
public class TransactionChallengesMappingServiceImpl implements
		ITransactionChallengesMappingService {

	@Autowired
	private ITransactionChallengesMappingDao transactionChallengesMappingDao;

	@Override
	@Transactional
	public TransactionChallengesMapping insertTransactionChallengesMapping(
			TransactionChallengesMapping transactionChallengesMapping) {
		return transactionChallengesMappingDao.insertTransactionChallengesMapping(transactionChallengesMapping);
	}

	@Override
	@Transactional(readOnly=true)
	public TransactionChallengesMapping fetchTransactionByChallengeId(
			String challengeId) {
		return transactionChallengesMappingDao.fetchTransactionByChallengeId(challengeId);
	}

	@Override
	@Transactional(readOnly=true)
	public TransactionChallengesMapping fetchTransactionByTransactionId(
			String transactionId) {
		return transactionChallengesMappingDao.fetchTransactionByTransactionId(transactionId);
	}

}
