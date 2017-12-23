package com.gamingzeus.pms.api.getTransactionChallengesMapping;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceRequest;

public class GetTransactionChallengesMappingRequest extends ServiceRequest {

	private static final long serialVersionUID = -3910117386776309832L;

	@Tag(100)
	private String challengeId;

	@Tag(101)
	private String transactionId;

	public GetTransactionChallengesMappingRequest(String challengeId,
			String transactionId) {
		super();
		this.challengeId = challengeId;
		this.transactionId = transactionId;
	}

	public GetTransactionChallengesMappingRequest() {
		super();
	}

	public String getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(String challengeId) {
		this.challengeId = challengeId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "GetTransactionChallengesMappingRequest [challengeId="
				+ challengeId + ", transactionId=" + transactionId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((challengeId == null) ? 0 : challengeId.hashCode());
		result = prime * result
				+ ((transactionId == null) ? 0 : transactionId.hashCode());
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
		GetTransactionChallengesMappingRequest other = (GetTransactionChallengesMappingRequest) obj;
		if (challengeId == null) {
			if (other.challengeId != null)
				return false;
		} else if (!challengeId.equals(other.challengeId))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
}
