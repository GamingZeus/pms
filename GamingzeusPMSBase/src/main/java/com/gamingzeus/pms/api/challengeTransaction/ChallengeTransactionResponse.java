package com.gamingzeus.pms.api.challengeTransaction;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceResponse;

public class ChallengeTransactionResponse extends ServiceResponse {

	private static final long serialVersionUID = 3820077832521324029L;

	@Tag(100)
	private String winnerTransactionId;

	@Tag(101)
	private String loserTransactionId;

	public ChallengeTransactionResponse(String winnerTransactionId,
			String loserTransactionId) {
		super();
		this.winnerTransactionId = winnerTransactionId;
		this.loserTransactionId = loserTransactionId;
	}

	public ChallengeTransactionResponse() {
		super();
	}

	public String getWinnerTransactionId() {
		return winnerTransactionId;
	}

	public void setWinnerTransactionId(String winnerTransactionId) {
		this.winnerTransactionId = winnerTransactionId;
	}

	public String getLoserTransactionId() {
		return loserTransactionId;
	}

	public void setLoserTransactionId(String loserTransactionId) {
		this.loserTransactionId = loserTransactionId;
	}

	@Override
	public String toString() {
		return "ChallengeTransactionResponse [winnerTransactionId="
				+ winnerTransactionId + ", loserTransactionId="
				+ loserTransactionId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((loserTransactionId == null) ? 0 : loserTransactionId
						.hashCode());
		result = prime
				* result
				+ ((winnerTransactionId == null) ? 0 : winnerTransactionId
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
		ChallengeTransactionResponse other = (ChallengeTransactionResponse) obj;
		if (loserTransactionId == null) {
			if (other.loserTransactionId != null)
				return false;
		} else if (!loserTransactionId.equals(other.loserTransactionId))
			return false;
		if (winnerTransactionId == null) {
			if (other.winnerTransactionId != null)
				return false;
		} else if (!winnerTransactionId.equals(other.winnerTransactionId))
			return false;
		return true;
	}
}
