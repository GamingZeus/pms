package com.gamingzeus.pms.dbaccess.mysql.transactionChallengesMapping;

import com.gamingzeus.pms.core.entity.TransactionChallengesMapping;

public interface ITransactionChallengesMappingDao {
	TransactionChallengesMapping insertTransactionChallengesMapping(TransactionChallengesMapping transactionChallengesMapping);
	TransactionChallengesMapping fetchTransactionByChallengeId(String challengeId);
	TransactionChallengesMapping fetchTransactionByTransactionId(String transactionId);
}