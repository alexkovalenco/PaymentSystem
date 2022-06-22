package com.payment.dto.account;

import com.payment.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountViewDTO {

	private String account_id;
	private String account_num;
	private String account_type;
	private Double balance;

	public AccountViewDTO(Account account){
		this.account_id = account.getId().toString();
		this.account_num = account.getAccountNum();
		this.account_type = account.getAccountType();
		this.balance = account.getBalance();
	}

}
