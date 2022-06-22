package com.payment.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.model.Payment;
import lombok.Data;

import java.util.Objects;

@Data
public class PaymentViewDTO {

	@JsonProperty("payment_id")
	private String paymentId;
	private String status;

	public PaymentViewDTO(Payment payment){
		this.paymentId = Objects.toString(payment.getId());
		this.status = payment.isPaymentStatus() ? "ok" : "error";
	}

}
