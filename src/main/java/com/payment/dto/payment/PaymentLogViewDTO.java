package com.payment.dto.payment;

import com.payment.dto.client.ClientViewDTO;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.model.Payment;
import lombok.Data;

@Data
public class PaymentLogViewDTO {

	private String payment_id;
	private String timestamp;
	private String src_acc_num;
	private String dest_acc_num;
	private Double amount;
	private ClientViewDTO payer;
	private ClientViewDTO recipient;

	public PaymentLogViewDTO(Payment payment, Account srcAcc, Account destAcc, Client payer, Client recipient){
		this.payment_id = payment.getId().toString();
		this.timestamp = payment.getDateCreated() != null ? payment.getDateCreated().toString() : null;
		this.src_acc_num = srcAcc.getAccountNum();
		this.dest_acc_num = destAcc.getAccountNum();
		this.amount = payment.getAmount();
		this.payer = new ClientViewDTO(payer);
		this.recipient = new ClientViewDTO(recipient);
	}

}
