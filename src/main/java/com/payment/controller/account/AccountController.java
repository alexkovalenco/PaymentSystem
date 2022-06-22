package com.payment.controller.account;

import com.payment.dto.DTOHelper;
import com.payment.dto.account.AccountDTO;
import com.payment.dto.account.AccountViewDTO;
import com.payment.dto.client.ClientDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.model.Employee;
import com.payment.repository.EmployeeRepository;
import com.payment.repository.account.AccountRepository;
import com.payment.service.account.AccountService;
import com.payment.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity getAccountById(@PathVariable(value = "id") BigInteger id)
            throws ResourceNotFoundException {
        Account account = accountService.findOne(id);
        if(account == null){
            throw new ResourceNotFoundException("Account not found for this id :: " + id);
        }

        return ResponseEntity.ok().body(account);
    }

    @GetMapping("/client_id/{id}")
    public ResponseEntity getClientById(@PathVariable(value = "id") BigInteger id) {
        List<Account> accounts = accountService.findAllByClientId(id);
        List<AccountViewDTO> accountViewDTOList = DTOHelper.parseAccountToDto(accounts);
        return ResponseEntity.ok().body(accountViewDTOList);
    }

}
