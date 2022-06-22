package com.payment.service.account;

import com.payment.dto.account.AccountDTO;
import com.payment.model.Account;

import java.math.BigInteger;
import java.util.List;

public interface AccountService {

    Account create(AccountDTO item);
    Account save(Account item);
    Account findOne(BigInteger id);
    List<Account> findAllByClientId(BigInteger clientId);
}
