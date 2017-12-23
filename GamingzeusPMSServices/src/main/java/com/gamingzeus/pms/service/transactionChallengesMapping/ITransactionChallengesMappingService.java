package com.gamingzeus.pms.service.transactionChallengesMapping;

import com.gamingzeus.pms.core.entity.TransactionChallengesMapping;

public interface ITransactionChallengesMappingService {

	TransactionChallengesMapping insertTransactionChallengesMapping(
			TransactionChallengesMapping transactionChallengesMapping);

	TransactionChallengesMapping fetchTransactionByChallengeId(
			String challengeId);

	TransactionChallengesMapping fetchTransactionByTransactionId(
			String transactionId);
}
