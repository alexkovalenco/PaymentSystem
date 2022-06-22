package com.payment.service.payment;

import com.payment.dto.payment.PaymentDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Payment;

import java.math.BigInteger;

public interface PaymentService {

    Payment create(PaymentDTO item) throws ResourceNotFoundException;
    Payment save(Payment item);
    Payment findOne(BigInteger id);
}
