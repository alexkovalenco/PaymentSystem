package com.payment.service.payment.impl;

import com.payment.dto.payment.PaymentDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.model.Payment;
import com.payment.repository.payment.PaymentRepository;
import com.payment.service.account.AccountService;
import com.payment.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigInteger;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountService accountService;

    @Override
    @Transactional
    public Payment create(PaymentDTO item) throws ResourceNotFoundException {
        Account sourceAcc = accountService.findOne(item.getSourceAccId());
        Account destAcc = accountService.findOne(item.getDestAccId());
        boolean paymentStatus = true;

        if(sourceAcc == null || destAcc == null || sourceAcc.getBalance() < item.getAmount()) {
            paymentStatus = false;
        }
        Payment payment = new Payment(item.getSourceAccId(), item.getDestAccId(), item.getAmount(),
                item.getReason(), paymentStatus);
        if(paymentStatus){
            sourceAcc.setBalance(sourceAcc.getBalance() - item.getAmount());
            destAcc.setBalance(destAcc.getBalance() + item.getAmount());
            accountService.save(sourceAcc);
            accountService.save(destAcc);
            //todo need change Client acc
        }
        paymentRepository.save(payment);

        return payment;
    }

    @Override
    public Payment save(Payment item) {
        return paymentRepository.save(item);
    }

    @Override
    public Payment findOne(BigInteger id) {
        return paymentRepository.getOne(id);
    }
}
