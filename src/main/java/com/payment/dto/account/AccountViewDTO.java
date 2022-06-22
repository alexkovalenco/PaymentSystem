package com.payment.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountViewDTO {

	@JsonProperty("account_id")
	private String accountId;
	@JsonProperty("account_num")
	private String accountNum;
	@JsonProperty("account_type")
	private String accountType;
	private Double balance;

	public AccountViewDTO(Account account){
		this.accountId = account.getId().toString();
		this.accountNum = account.getAccountNum();
		this.accountType = account.getAccountType();
		this.balance = account.getBalance();
	}

}
