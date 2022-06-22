package com.payment.controller.client;

import com.payment.dto.client.ClientDTO;
import com.payment.model.Client;
import com.payment.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity createEmployee(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.create(clientDTO);
        Map<String, BigInteger> result = new HashMap() {{
            put("client_id", client.getId());
        }};
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
