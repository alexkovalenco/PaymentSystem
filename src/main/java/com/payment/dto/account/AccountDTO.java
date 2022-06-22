package com.payment.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.model.Account;
import com.payment.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO  {

	@JsonProperty("account_num")
	private String accountNum;

	@JsonProperty("account_type")
	private String accountType;

	private Double balance;

	private BigInteger clientId;
}
