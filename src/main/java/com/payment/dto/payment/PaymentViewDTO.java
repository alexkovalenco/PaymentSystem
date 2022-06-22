package com.payment.dto.payment;

import com.payment.model.Payment;
import lombok.Data;

@Data
public class PaymentViewDTO {

	private String payment_id;
	private String status;

	public PaymentViewDTO(Payment payment){
		this.payment_id = payment.getId().toString();
		this.status = payment.isPaymentStatus() ? "ok" : "error";
	}

}
