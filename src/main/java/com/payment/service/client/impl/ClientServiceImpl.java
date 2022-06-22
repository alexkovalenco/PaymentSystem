package com.payment.service.client.impl;

import com.payment.dto.account.AccountDTO;
import com.payment.dto.client.ClientDTO;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.repository.client.ClientRepository;
import com.payment.service.account.AccountService;
import com.payment.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Client create(ClientDTO item) {
        Client client = new Client();
        client.setFirstName(item.getFirstName());
        client.setLastName(item.getLastName());
        List<AccountDTO> accountsDTO = item.getAccounts();
        if(accountsDTO != null){
            client = clientRepository.save(client);
            List<Account> accounts = new ArrayList<>();
            for(AccountDTO accountDTO : accountsDTO){
                accountDTO.setClientId(client.getId());
                Account account = accountService.create(accountDTO);
                accounts.add(account);
            }
            client.setAccounts(accounts);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client save(Client item) {
        return clientRepository.save(item);
    }

    @Override
    public Client findOne(BigInteger id) {
        return clientRepository.getOne(id);
    }
}
