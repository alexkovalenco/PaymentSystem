package com.payment.service.payment.impl;

import com.payment.dto.DTOHelper;
import com.payment.dto.payment.PaymentDTO;
import com.payment.dto.payment.PaymentLogDTO;
import com.payment.dto.payment.PaymentLogViewDTO;
import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.model.Payment;
import com.payment.repository.payment.PaymentRepository;
import com.payment.service.account.AccountService;
import com.payment.service.client.ClientService;
import com.payment.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final AccountService accountService;
    private final ClientService clientService;

    @Override
    @Transactional
    public Payment create(PaymentDTO item) {
        Account sourceAcc = accountService.findOne(item.getSourceAccId());
        Account destAcc = accountService.findOne(item.getDestAccId());
        boolean paymentStatus = true;

        if(sourceAcc == null || destAcc == null || sourceAcc.getBalance() < item.getAmount()) {
            paymentStatus = false;
        }
        Payment payment = new Payment(item.getSourceAccId(), item.getDestAccId(), item.getAmount(),
                item.getReason(), paymentStatus, new Date());
        if(paymentStatus){
            sourceAcc.setBalance(sourceAcc.getBalance() - item.getAmount());
            destAcc.setBalance(destAcc.getBalance() + item.getAmount());
            accountService.save(sourceAcc);
            accountService.save(destAcc);
        }
        paymentRepository.save(payment);

        return payment;
    }

    @Override
    public List<Payment> createPayments(List<PaymentDTO> items) {
        return items.stream().map(item -> create(item)).collect(Collectors.toList());
    }

    @Override
    public Payment save(Payment item) {
        return paymentRepository.save(item);
    }

    @Override
    public Payment findOne(BigInteger id) {
        return paymentRepository.getOne(id);
    }

    @Override
    public List<Payment> findAllBySourceAccIdAndDestAccId(BigInteger sourceAccId, BigInteger destAccId) {
        return paymentRepository.findAllBySourceAccIdAndDestAccId(sourceAccId, destAccId);
    }

    @Override
    public List<PaymentLogViewDTO> getPaymentLogs(PaymentLogDTO paymentLogDTO) {
        Client payer = clientService.findOne(paymentLogDTO.getPayerId());
        Client recipient = clientService.findOne(paymentLogDTO.getRecipientId());
        Account sourceAcc = accountService.findOne(paymentLogDTO.getSourceAccId());
        Account destAcc = accountService.findOne(paymentLogDTO.getDestAccId());
        List<Payment> payments = findAllBySourceAccIdAndDestAccId(paymentLogDTO.getSourceAccId(), paymentLogDTO.getDestAccId());
        List<PaymentLogViewDTO> paymentLogViewDTOList = new ArrayList<>();
        for(Payment payment : payments){
            paymentLogViewDTOList.add(DTOHelper.parsePaymentLogToDto(payment,sourceAcc,destAcc, payer, recipient));
        }
        return paymentLogViewDTOList;
    }
}
