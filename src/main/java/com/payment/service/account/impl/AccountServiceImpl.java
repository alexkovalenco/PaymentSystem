package com.payment.service.account.impl;

import com.payment.dto.account.AccountDTO;
import com.payment.model.Account;
import com.payment.repository.account.AccountRepository;
import com.payment.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account create(AccountDTO item) {
        Account account = new Account();
        account.setAccountNum(item.getAccountNum());
        account.setAccountType(item.getAccountType());
        account.setBalance(item.getBalance());
        account.setClientId(item.getClientId());
        return accountRepository.save(account);
    }

    @Override
    public Account save(Account item) {
        return accountRepository.save(item);
    }

    @Override
    public Account findOne(BigInteger id) {
        return accountRepository.getOne(id);
    }

    @Override
    public List<Account> findAllByClientId(BigInteger clientId) {
        return accountRepository.findAllByClientId(clientId);
    }
}
