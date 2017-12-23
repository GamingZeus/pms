package com.gamingzeus.pms.api.getTransactionChallengesMapping;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceResponse;

public class GetTransactionChallengesMappingResponse extends ServiceResponse {

	private static final long serialVersionUID = 3820077832521324029L;

	@Tag(100)
	private TransactionDetails transactionDetails;

	public GetTransactionChallengesMappingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetTransactionChallengesMappingResponse(String code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public GetTransactionChallengesMappingResponse(
			TransactionDetails transactionDetails) {
		super();
		this.transactionDetails = transactionDetails;
	}

	public TransactionDetails getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(TransactionDetails transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	@Override
	public String toString() {
		return "GetTransactionChallengesMappingResponse [transactionDetails="
				+ transactionDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((transactionDetails == null) ? 0 : transactionDetails
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetTransactionChallengesMappingResponse other = (GetTransactionChallengesMappingResponse) obj;
		if (transactionDetails == null) {
			if (other.transactionDetails != null)
				return false;
		} else if (!transactionDetails.equals(other.transactionDetails))
			return false;
		return true;
	}
}
