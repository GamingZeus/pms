package com.gamingzeus.pms.api.getWalletDetails;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceResponse;

public class GetWalletDetailsResponse extends ServiceResponse{

	private static final long serialVersionUID = 3820077832521324029L;
	
	@Tag(100)
	private String userId;
	
	@Tag(101)
	private Double balance;
	
	@Tag(102)
	private String currency;

	public GetWalletDetailsResponse() {
		super();
	}

	public GetWalletDetailsResponse(String userId, Double balance,
			String currency) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.currency = currency;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "GetWalletDetailsResponse [userId=" + userId + ", balance="
				+ balance + ", currency=" + currency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		GetWalletDetailsResponse other = (GetWalletDetailsResponse) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
