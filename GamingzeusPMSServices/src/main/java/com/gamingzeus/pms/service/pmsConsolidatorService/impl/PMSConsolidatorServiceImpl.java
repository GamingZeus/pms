package com.gamingzeus.pms.service.pmsConsolidatorService.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingzeus.base.exception.FocusWSErrorCode;
import com.gamingzeus.base.utils.DateUtils;
import com.gamingzeus.base.utils.StringUtils;
import com.gamingzeus.pms.api.challengeTransaction.ChallengeTransactionRequest;
import com.gamingzeus.pms.api.challengeTransaction.ChallengeTransactionResponse;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingRequest;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingResponse;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.TransactionDetails;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryRequest;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryResponse;
import com.gamingzeus.pms.api.getTransactionHistory.TransactionDTO;
import com.gamingzeus.pms.api.getWalletDetails.GetWalletDetailsRequest;
import com.gamingzeus.pms.api.getWalletDetails.GetWalletDetailsResponse;
import com.gamingzeus.pms.core.entity.Transaction;
import com.gamingzeus.pms.core.entity.TransactionChallengesMapping;
import com.gamingzeus.pms.core.entity.Wallet;
import com.gamingzeus.pms.service.pmsConsolidatorService.IPMSConsolidatorService;
import com.gamingzeus.pms.service.transaction.ITransactionService;
import com.gamingzeus.pms.service.transactionChallengesMapping.ITransactionChallengesMappingService;
import com.gamingzeus.pms.service.wallet.IWalletService;

@Service("pmsConsolidatorService")
public class PMSConsolidatorServiceImpl implements IPMSConsolidatorService {

	@Autowired
	private ITransactionService transactionService;

	@Autowired
	private ITransactionChallengesMappingService transactionChallengesMappingService;

	@Autowired
	private IWalletService walletService;

	@Override
	public GetTransactionHistoryResponse getTransactionHistory(
			GetTransactionHistoryRequest request) {
		GetTransactionHistoryResponse response = null;
		if (StringUtils.isEmpty(request.getUserId())) {
			response = new GetTransactionHistoryResponse();
			response.setCode(FocusWSErrorCode.INVALID_REQUEST.getCode());
			response.setMessage("Request Validation Failed");
			return response;
		}

		List<Transaction> transactionList = transactionService
				.fetchPaginatedTransaction(request.getUserId(),
						request.getStart(), request.getPageSize());
		List<TransactionDTO> transactionDTOList = new ArrayList<TransactionDTO>();
		if (transactionList != null && !transactionList.isEmpty()) {
			for (Transaction t : transactionList) {
				TransactionDTO transactionDTO = new TransactionDTO();
				transactionDTO.setAmount(t.getAmount());
				transactionDTO.setCode("0");
				transactionDTO.setCreated(t.getCreated());
				transactionDTO.setCurrency(t.getCurrency());
				transactionDTO.setId(t.getId());
				transactionDTO.setPaymentGateway(t.getPaymentGateway());
				transactionDTO.setPaymentGatewayId(t.getPaymentGatewayId());
				transactionDTO.setType(t.getType());
				transactionDTO.setUpdated(t.getUpdated());
				transactionDTO.setUserId(t.getUserId());
				transactionDTOList.add(transactionDTO);
			}
		}
		response = new GetTransactionHistoryResponse();
		response.setTransactionList(transactionDTOList);
		response.setCode("0");
		return response;
	}

	@Override
	public GetTransactionChallengesMappingResponse getTransactionChallengesMappingResponse(
			GetTransactionChallengesMappingRequest request) {
		GetTransactionChallengesMappingResponse response = null;
		if (StringUtils.isEmpty(request.getChallengeId())) {
			response = new GetTransactionChallengesMappingResponse();
			response.setCode(FocusWSErrorCode.INVALID_REQUEST.getCode());
			response.setMessage("Request Validation Failed");
			return response;
		}

		TransactionChallengesMapping tcm = transactionChallengesMappingService
				.fetchTransactionByChallengeId(request.getChallengeId());
		TransactionDetails transactionDTO = new TransactionDetails();
		if (tcm != null) {
			Transaction t = transactionService.fetchTransactionById(tcm
					.getTransactionId());
			if (t != null) {
				transactionDTO.setAmount(t.getAmount());
				transactionDTO.setCode("0");
				transactionDTO.setCreated(t.getCreated());
				transactionDTO.setCurrency(t.getCurrency());
				transactionDTO.setId(t.getId());
				transactionDTO.setPaymentGateway(t.getPaymentGateway());
				transactionDTO.setPaymentGatewayId(t.getPaymentGatewayId());
				transactionDTO.setType(t.getType());
				transactionDTO.setUpdated(t.getUpdated());
				transactionDTO.setUserId(t.getUserId());
			}
		}
		response = new GetTransactionChallengesMappingResponse();
		response.setTransactionDetails(transactionDTO);
		response.setCode("0");
		return response;
	}

	@Override
	public GetWalletDetailsResponse getWalletDetails(
			GetWalletDetailsRequest request) {
		GetWalletDetailsResponse response = null;
		if (StringUtils.isEmpty(request.getUserId())) {
			response = new GetWalletDetailsResponse();
			response.setCode(FocusWSErrorCode.INVALID_REQUEST.getCode());
			response.setMessage("Request Validation Failed");
			return response;
		}
		response = new GetWalletDetailsResponse();
		Wallet wallet = walletService.fetchWalletDetailsByUserId(request
				.getUserId());
		if (wallet != null) {
			response.setBalance(wallet.getBalance());
			response.setUserId(wallet.getUserId());
			response.setCurrency(wallet.getCurrency());
		}
		response.setCode("0");
		return null;
	}

	@Override
	public ChallengeTransactionResponse getWalletDetails(
			ChallengeTransactionRequest request) {
		ChallengeTransactionResponse response = null;
		if (StringUtils.isEmpty(request.getWinnerUserId())
				|| StringUtils.isEmpty(request.getLoserUserId())
				|| StringUtils.isEmpty(request.getChallengeId())) {
			response = new ChallengeTransactionResponse();
			response.setCode(FocusWSErrorCode.INVALID_REQUEST.getCode());
			response.setMessage("Request Validation Failed");
			return response;
		}
		
		String transactionIdWinner = UUID.randomUUID().toString();
		String transactionIdLoser = UUID.randomUUID().toString();
		response = new ChallengeTransactionResponse();
		Transaction tWinner = new Transaction();
		tWinner.setAmount(request.getAmount());
		tWinner.setCreated(DateUtils.getCurrentTime());
		tWinner.setUpdated(DateUtils.getCurrentTime());
		tWinner.setCurrency(request.getCurrency());
		tWinner.setId(transactionIdWinner);
		tWinner.setType("DEPOSIT");
		tWinner.setUserId(request.getWinnerUserId());
		transactionService.insertTransaction(tWinner);
		
		Transaction tLoser = new Transaction();
		tLoser.setAmount(request.getAmount());
		tLoser.setCreated(DateUtils.getCurrentTime());
		tLoser.setUpdated(DateUtils.getCurrentTime());
		tLoser.setCurrency(request.getCurrency());
		tLoser.setId(transactionIdLoser);
		tLoser.setType("WITHDRAW");
		tLoser.setUserId(request.getLoserUserId());
		transactionService.insertTransaction(tLoser);
		
		TransactionChallengesMapping tcmWinner = new TransactionChallengesMapping();
		tcmWinner.setChallengeId(request.getChallengeId());
		tcmWinner.setTransactionId(transactionIdWinner);
		tcmWinner.setCreated(DateUtils.getCurrentTime());
		tcmWinner.setUpdated(DateUtils.getCurrentTime());
		transactionChallengesMappingService.insertTransactionChallengesMapping(tcmWinner);
		
		TransactionChallengesMapping tcmLoser = new TransactionChallengesMapping();
		tcmLoser.setChallengeId(request.getChallengeId());
		tcmLoser.setTransactionId(transactionIdLoser);
		tcmLoser.setCreated(DateUtils.getCurrentTime());
		tcmLoser.setUpdated(DateUtils.getCurrentTime());
		transactionChallengesMappingService.insertTransactionChallengesMapping(tcmLoser);
		
		response.setCode("0");
		response.setLoserTransactionId(transactionIdLoser);
		response.setWinnerTransactionId(transactionIdWinner);
		return response;
	}
}
