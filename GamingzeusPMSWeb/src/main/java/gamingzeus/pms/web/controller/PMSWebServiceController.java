package gamingzeus.pms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamingzeus.pms.api.challengeTransaction.ChallengeTransactionRequest;
import com.gamingzeus.pms.api.challengeTransaction.ChallengeTransactionResponse;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingRequest;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingResponse;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryRequest;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryResponse;
import com.gamingzeus.pms.api.getWalletDetails.GetWalletDetailsRequest;
import com.gamingzeus.pms.api.getWalletDetails.GetWalletDetailsResponse;
import com.gamingzeus.pms.service.pmsConsolidatorService.IPMSConsolidatorService;

@RestController
@RequestMapping("/service/pms")
public class PMSWebServiceController implements ApplicationContextAware {

	private static final Logger LOG = LoggerFactory
			.getLogger(PMSWebServiceController.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IPMSConsolidatorService pmsConsolidatorService;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@RequestMapping("/getTransactionHistory")
	public GetTransactionHistoryResponse getTransactionHistory(
			@RequestBody GetTransactionHistoryRequest request) {
		GetTransactionHistoryResponse response = null;
		try {
			response = pmsConsolidatorService.getTransactionHistory(request);
			response.setProtocol(request.getRequestProtocol());
			response.setCode("0");
		} catch (Throwable e) {
			LOG.error("Something went wrong during get transaction history");
			LOG.error("Exception", e);
			LOG.info("getTransactionHistory error:" + e);
			response = new GetTransactionHistoryResponse();
			response.setCode("1");
			response.setMessage("Something is wrong");
			return response;
		}
		return response;
	}
	
	@RequestMapping("/getTransactionChallengesMappingResponse")
	public GetTransactionChallengesMappingResponse getTransactionChallengesMappingResponse(
			@RequestBody GetTransactionChallengesMappingRequest request) {
		GetTransactionChallengesMappingResponse response = null;
		try {
			response = pmsConsolidatorService.getTransactionChallengesMappingResponse(request);
			response.setProtocol(request.getRequestProtocol());
			response.setCode("0");
		} catch (Throwable e) {
			LOG.error("Something went wrong during get transaction challenges mapping");
			LOG.error("Exception", e);
			LOG.info("getTransactionChallengesMappingResponse error:" + e);
			response = new GetTransactionChallengesMappingResponse();
			response.setCode("1");
			response.setMessage("Something is wrong");
			return response;
		}
		return response;
	}
	
	@RequestMapping("/getWalletDetails")
	public GetWalletDetailsResponse getWalletDetails(
			@RequestBody GetWalletDetailsRequest request) {
		GetWalletDetailsResponse response = null;
		try {
			response = pmsConsolidatorService.getTransactionChallengesMappingResponse(request);
			response.setProtocol(request.getRequestProtocol());
			response.setCode("0");
		} catch (Throwable e) {
			LOG.error("Something went wrong during get transaction challenges mapping");
			LOG.error("Exception", e);
			LOG.info("Healthcheck error:" + e);
			response = new GetWalletDetailsResponse();
			response.setCode("1");
			response.setMessage("Something is wrong");
			return response;
		}
		return response;
	}
	
	@RequestMapping("/challengeTransaction")
	public ChallengeTransactionResponse challengeTransaction(
			@RequestBody ChallengeTransactionRequest request) {
		GetWalletDetailsResponse response = null;
		try {
			response = pmsConsolidatorService.getTransactionChallengesMappingResponse(request);
			response.setProtocol(request.getRequestProtocol());
			response.setCode("0");
		} catch (Throwable e) {
			LOG.error("Something went wrong during get transaction challenges mapping");
			LOG.error("Exception", e);
			LOG.info("Healthcheck error:" + e);
			response = new GetWalletDetailsResponse();
			response.setCode("1");
			response.setMessage("Something is wrong");
			return response;
		}
		return response;
	}
	
}
