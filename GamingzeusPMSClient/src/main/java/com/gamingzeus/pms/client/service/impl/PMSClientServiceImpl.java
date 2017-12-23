package com.gamingzeus.pms.client.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingzeus.base.exception.FocusWSErrorCode;
import com.gamingzeus.base.exception.FocusWSException;
import com.gamingzeus.base.transport.http.service.IHttpTransportService;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingRequest;
import com.gamingzeus.pms.api.getTransactionChallengesMapping.GetTransactionChallengesMappingResponse;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryRequest;
import com.gamingzeus.pms.api.getTransactionHistory.GetTransactionHistoryResponse;
import com.gamingzeus.pms.client.service.IPMSClientService;

@Service("pmsClientService")
public class PMSClientServiceImpl implements IPMSClientService {

	private static final Logger LOG = LoggerFactory
			.getLogger(PMSClientServiceImpl.class);

	private static final String FRS_SERVICE_URL = "/service/pms";

	private String webServiceBaseURL = null;
	private String webServiceURL;

	@Autowired
	private IHttpTransportService httpTransportService;

	@PostConstruct
	public void init() {
		httpTransportService.registerService("/service/frs/", "frsserver.");
	}

    private String getPMSWebServiceURL() throws FocusWSException {
        if (webServiceURL == null || webServiceBaseURL == null) {
            throw new FocusWSException(FocusWSErrorCode.BASE_URL_MISSING_EXCEPTION);
        }
        return webServiceURL;
    }
    
	@Override
	public GetTransactionHistoryResponse getTransactionHistory(
			GetTransactionHistoryRequest request) throws FocusWSException{
		String url = getPMSWebServiceURL() + "/getTransactionHistory";
		GetTransactionHistoryResponse response = (GetTransactionHistoryResponse) httpTransportService
				.executeRequest(url, request, null,
						GetTransactionHistoryResponse.class);
		return response;
	}

	@Override
	public GetTransactionChallengesMappingResponse getTransactionChallengesMappingResponse(
			GetTransactionChallengesMappingRequest request) throws FocusWSException{
		String url = getPMSWebServiceURL() + "/getTransactionChallengesMappingResponse";
		GetTransactionChallengesMappingResponse response = (GetTransactionChallengesMappingResponse) httpTransportService
				.executeRequest(url, request, null,
						GetTransactionChallengesMappingResponse.class);
		return response;
	}
}
