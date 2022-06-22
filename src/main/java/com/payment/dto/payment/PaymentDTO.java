package com.payment.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.dto.account.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

	@JsonProperty("source_acc_id")
	private BigInteger sourceAccId;

	@JsonProperty("dest_acc_id")
	private BigInteger destAccId;

	private Double amount;

	private String reason;

}
