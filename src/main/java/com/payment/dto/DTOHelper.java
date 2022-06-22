package com.payment.dto;

import com.payment.dto.account.AccountViewDTO;
import com.payment.model.Account;

import java.util.List;
import java.util.stream.Collectors;

public class DTOHelper {

    public static List<AccountViewDTO> parseAccountToDto(List<Account> accounts) {
        return accounts.stream()
                .map(AccountViewDTO::new).collect(Collectors.toList());
    }
}
