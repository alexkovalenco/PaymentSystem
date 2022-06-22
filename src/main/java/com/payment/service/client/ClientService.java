package com.payment.service.client;

import com.payment.dto.client.ClientDTO;
import com.payment.model.Client;

import java.math.BigInteger;

public interface ClientService {

    Client create(ClientDTO item);
    Client save(Client item);
    Client findOne(BigInteger id);
}
