package com.payment.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.model.Account;
import com.payment.model.Client;
import lombok.Data;

@Data
public class ClientViewDTO {

	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;

	public ClientViewDTO(Client client){
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
	}

}
