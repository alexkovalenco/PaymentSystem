package com.payment.service.payment;

import com.payment.dto.payment.PaymentDTO;
import com.payment.dto.payment.PaymentLogDTO;
import com.payment.dto.payment.PaymentLogViewDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Payment;

import java.math.BigInteger;
import java.util.List;

public interface PaymentService {

    Payment create(PaymentDTO item);
    List<Payment> createPayments(List<PaymentDTO> items);
    Payment save(Payment item);
    Payment findOne(BigInteger id);
    List<Payment> findAllBySourceAccIdAndDestAccId(BigInteger sourceAccId, BigInteger destAccId);
    List<PaymentLogViewDTO> getPaymentLogs(PaymentLogDTO paymentLogDTO);
}
