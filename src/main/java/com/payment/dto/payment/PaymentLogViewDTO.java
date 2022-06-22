package com.payment.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.dto.client.ClientViewDTO;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.model.Payment;
import lombok.Data;

import java.util.Objects;

@Data
public class PaymentLogViewDTO {

	@JsonProperty("payment_id")
	private String paymentId;
	private String timestamp;
	@JsonProperty("src_acc_num")
	private String srcAccNum;
	@JsonProperty("dest_acc_num")
	private String destAccNum;
	private Double amount;
	private ClientViewDTO payer;
	private ClientViewDTO recipient;

	public PaymentLogViewDTO(Payment payment, Account srcAcc, Account destAcc, Client payer, Client recipient){
		this.paymentId = Objects.toString(payment.getId());
		this.timestamp = Objects.toString(payment.getDateCreated());
		this.srcAccNum = srcAcc.getAccountNum();
		this.destAccNum = destAcc.getAccountNum();
		this.amount = payment.getAmount();
		this.payer = new ClientViewDTO(payer);
		this.recipient = new ClientViewDTO(recipient);
	}

}
