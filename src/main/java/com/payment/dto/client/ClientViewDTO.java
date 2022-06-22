package com.payment.dto.client;

import com.payment.model.Account;
import com.payment.model.Client;
import lombok.Data;

@Data
public class ClientViewDTO {

	private String first_name;
	private String last_name;

	public ClientViewDTO(Client client){
		this.first_name = client.getFirstName();
		this.last_name = client.getLastName();
	}

}
