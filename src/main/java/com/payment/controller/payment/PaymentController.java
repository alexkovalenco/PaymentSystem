package com.payment.controller.payment;

import com.payment.dto.payment.PaymentDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Payment;
import com.payment.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity createPayment(@RequestBody PaymentDTO paymentDTO) throws ResourceNotFoundException {
        Payment payment = paymentService.create(paymentDTO);
        return new ResponseEntity<>("\"payment_id\": " + payment.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/create/pack")
    public ResponseEntity createPackPayment(@RequestBody PaymentDTO paymentDTO) throws ResourceNotFoundException {
        Payment payment = paymentService.create(paymentDTO);
        return new ResponseEntity<>("\"payment_id\": " + payment.getId(), HttpStatus.CREATED);
    }
}
