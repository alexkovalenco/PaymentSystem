package com.payment.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentLogDTO {

	@JsonProperty("payer_id")
	private BigInteger payerId;

	@JsonProperty("recipient_id")
	private BigInteger recipientId;

	@JsonProperty("source_acc_id")
	private BigInteger sourceAccId;

	@JsonProperty("dest_acc_id")
	private BigInteger destAccId;

}
