package com.payment.controller.payment;

import com.payment.dto.DTOHelper;
import com.payment.dto.account.AccountViewDTO;
import com.payment.dto.payment.PaymentDTO;
import com.payment.dto.payment.PaymentLogDTO;
import com.payment.dto.payment.PaymentLogViewDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.model.Payment;
import com.payment.service.account.AccountService;
import com.payment.service.client.ClientService;
import com.payment.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(path="/create", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity createPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentService.create(paymentDTO);
        return new ResponseEntity<>("\"payment_id\": " + payment.getId(), HttpStatus.CREATED);
    }

    @PostMapping(path="/create/pack", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity createPackPayment(@RequestBody List<PaymentDTO> paymentDTOs) {
        List<Payment> payments = paymentService.createPayments(paymentDTOs);
        return ResponseEntity.ok().body(DTOHelper.parsePaymentToDto(payments));
    }

    @PostMapping(path="/logs", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getPaymentLogs(@RequestBody PaymentLogDTO paymentLogDTO)  {
        return ResponseEntity.ok().body(paymentService.getPaymentLogs(paymentLogDTO));

    }
}
