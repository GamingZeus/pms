package com.gamingzeus.pms.api.challengeTransaction;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceRequest;

public class ChallengeTransactionRequest extends ServiceRequest {

	private static final long serialVersionUID = -3910117386776309832L;

	@Tag(100)
	private String winnerUserId;

	@Tag(101)
	private String loserUserId;

	@Tag(102)
	private Double amount;

	@Tag(103)
	private String currency;

	@Tag(104)
	private String challengeId;

	public ChallengeTransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengeTransactionRequest(String winnerUserId, String loserUserId,
			Double amount, String currency, String challengeId) {
		super();
		this.winnerUserId = winnerUserId;
		this.loserUserId = loserUserId;
		this.amount = amount;
		this.currency = currency;
		this.challengeId = challengeId;
	}

	public String getWinnerUserId() {
		return winnerUserId;
	}

	public void setWinnerUserId(String winnerUserId) {
		this.winnerUserId = winnerUserId;
	}

	public String getLoserUserId() {
		return loserUserId;
	}

	public void setLoserUserId(String loserUserId) {
		this.loserUserId = loserUserId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(String challengeId) {
		this.challengeId = challengeId;
	}

	@Override
	public String toString() {
		return "ChallengeTransactionRequest [winnerUserId=" + winnerUserId
				+ ", loserUserId=" + loserUserId + ", amount=" + amount
				+ ", currency=" + currency + ", challengeId=" + challengeId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((challengeId == null) ? 0 : challengeId.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((loserUserId == null) ? 0 : loserUserId.hashCode());
		result = prime * result
				+ ((winnerUserId == null) ? 0 : winnerUserId.hashCode());
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
		ChallengeTransactionRequest other = (ChallengeTransactionRequest) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (challengeId == null) {
			if (other.challengeId != null)
				return false;
		} else if (!challengeId.equals(other.challengeId))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (loserUserId == null) {
			if (other.loserUserId != null)
				return false;
		} else if (!loserUserId.equals(other.loserUserId))
			return false;
		if (winnerUserId == null) {
			if (other.winnerUserId != null)
				return false;
		} else if (!winnerUserId.equals(other.winnerUserId))
			return false;
		return true;
	}
}
