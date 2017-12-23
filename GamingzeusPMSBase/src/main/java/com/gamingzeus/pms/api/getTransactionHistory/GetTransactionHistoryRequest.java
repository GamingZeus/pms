package com.gamingzeus.pms.api.getTransactionHistory;

import io.protostuff.Tag;

import com.gamingzeus.base.transport.ServiceRequest;

public class GetTransactionHistoryRequest extends ServiceRequest {

	private static final long serialVersionUID = -3910117386776309832L;

	@Tag(100)
	private String userId;

	@Tag(101)
	private int start;

	@Tag(102)
	private int pageSize;

	public GetTransactionHistoryRequest(String userId, int start, int pageSize) {
		super();
		this.userId = userId;
		this.start = start;
		this.pageSize = pageSize;
	}

	public GetTransactionHistoryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GetTransactionHistoryRequest [userId=" + userId + ", start="
				+ start + ", pageSize=" + pageSize + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pageSize;
		result = prime * result + start;
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
		GetTransactionHistoryRequest other = (GetTransactionHistoryRequest) obj;
		if (pageSize != other.pageSize)
			return false;
		if (start != other.start)
			return false;
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

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
