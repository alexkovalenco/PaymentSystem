package com.payment.controller.client;

import com.payment.dto.DTOHelper;
import com.payment.dto.account.AccountViewDTO;
import com.payment.dto.client.ClientDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Client;
import com.payment.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.create(clientDTO);
        return new ResponseEntity<>("\"client_id\": " + client.getId(), HttpStatus.CREATED);
    }
}
