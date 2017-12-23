package com.gamingzeus.pms.api.getTransactionHistory;

import io.protostuff.Tag;

import java.util.List;

import com.gamingzeus.base.transport.ServiceResponse;

public class GetTransactionHistoryResponse extends ServiceResponse{

	private static final long serialVersionUID = 3820077832521324029L;
	
	@Tag(100)
	List<TransactionDTO> transactionList;

	public GetTransactionHistoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetTransactionHistoryResponse(List<TransactionDTO> transactionList) {
		super();
		this.transactionList = transactionList;
	}

	public List<TransactionDTO> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<TransactionDTO> transactionList) {
		this.transactionList = transactionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((transactionList == null) ? 0 : transactionList.hashCode());
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
		GetTransactionHistoryResponse other = (GetTransactionHistoryResponse) obj;
		if (transactionList == null) {
			if (other.transactionList != null)
				return false;
		} else if (!transactionList.equals(other.transactionList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GetTransactionHistoryResponse [transactionList="
				+ transactionList + "]";
	}
}
