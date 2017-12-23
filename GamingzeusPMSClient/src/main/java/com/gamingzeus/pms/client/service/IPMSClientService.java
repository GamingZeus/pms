package com.gamingzeus.pms.client.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.gamingzeus.base.exception.FocusWSException;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingRequest;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingResponse;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryRequest;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryResponse;

public interface IPMSClientService {

	GetTransactionHistoryResponse getTransactionHistory(
			GetTransactionHistoryRequest request) throws FocusWSException;

	GetTransactionChallengesMappingResponse getTransactionChallengesMappingResponse(
			@RequestBody GetTransactionChallengesMappingRequest request) throws FocusWSException;
}
