package com.payment.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.dto.account.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("accounts")
	private List<AccountDTO> accounts;
}
