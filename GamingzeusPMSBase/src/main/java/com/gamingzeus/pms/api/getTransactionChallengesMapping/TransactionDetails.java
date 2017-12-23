package com.gamingzeus.pms.api.getTransactionChallengesMapping;

import io.protostuff.Tag;

import java.util.Date;

import com.gamingzeus.base.transport.ServiceResponse;

public class TransactionDetails extends ServiceResponse {

	private static final long serialVersionUID = 1549244416005484494L;

	@Tag(200)
	private String id;
	
	@Tag(201)
	private String userId;
	
	@Tag(202)
	private String type;
	
	@Tag(203)
	private Double amount;
	
	@Tag(204)
	private String currency;
	
	@Tag(205)
	private String paymentGatewayId;
	
	@Tag(206)
	private String paymentGateway;
	
	@Tag(207)
	private Date created;
	
	@Tag(208)
	private Date updated;

	public TransactionDetails(String id, String userId, String type, Double amount,
			String currency, String paymentGatewayId, String paymentGateway,
			Date created, Date updated) {
		super();
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.paymentGatewayId = paymentGatewayId;
		this.paymentGateway = paymentGateway;
		this.created = created;
		this.updated = updated;
	}

	public TransactionDetails() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPaymentGatewayId() {
		return paymentGatewayId;
	}

	public void setPaymentGatewayId(String paymentGatewayId) {
		this.paymentGatewayId = paymentGatewayId;
	}

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "TransactionDTO [id=" + id + ", userId=" + userId + ", type="
				+ type + ", amount=" + amount + ", currency=" + currency
				+ ", paymentGatewayId=" + paymentGatewayId
				+ ", paymentGateway=" + paymentGateway + ", created=" + created
				+ ", updated=" + updated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((paymentGateway == null) ? 0 : paymentGateway.hashCode());
		result = prime
				* result
				+ ((paymentGatewayId == null) ? 0 : paymentGatewayId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
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
		TransactionDetails other = (TransactionDetails) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paymentGateway == null) {
			if (other.paymentGateway != null)
				return false;
		} else if (!paymentGateway.equals(other.paymentGateway))
			return false;
		if (paymentGatewayId == null) {
			if (other.paymentGatewayId != null)
				return false;
		} else if (!paymentGatewayId.equals(other.paymentGatewayId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
