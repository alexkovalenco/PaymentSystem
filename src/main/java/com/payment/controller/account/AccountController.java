package com.payment.controller.account;

import com.payment.dto.DTOHelper;
import com.payment.dto.account.AccountViewDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") BigInteger id)
            throws ResourceNotFoundException {
        Account account = accountService.findOne(id);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found for this id :: " + id);
        }

        return ResponseEntity.ok().body(account);
    }

    @GetMapping("/client_id/{id}")
    public ResponseEntity<List<AccountViewDTO>> getClientById(@PathVariable(value = "id") BigInteger id) {
        List<Account> accounts = accountService.findAllByClientId(id);
        List<AccountViewDTO> accountViewDTOList = DTOHelper.parseAccountToDto(accounts);
        return ResponseEntity.ok().body(accountViewDTOList);
    }

}
