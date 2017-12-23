package com.gamingzeus.pms.api.getWalletDetails;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceRequest;

public class GetWalletDetailsRequest extends ServiceRequest {

	private static final long serialVersionUID = -3910117386776309832L;

	@Tag(100)
	private String userId;

	public GetWalletDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetWalletDetailsRequest(String userId) {
		super();
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "GetWalletDetailsRequest [userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		GetWalletDetailsRequest other = (GetWalletDetailsRequest) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
