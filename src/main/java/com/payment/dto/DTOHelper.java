package com.payment.dto;

import com.payment.dto.account.AccountViewDTO;
import com.payment.dto.payment.PaymentLogViewDTO;
import com.payment.dto.payment.PaymentViewDTO;
import com.payment.model.Account;
import com.payment.model.Client;
import com.payment.model.Payment;

import java.util.List;
import java.util.stream.Collectors;

public class DTOHelper {

    public static List<AccountViewDTO> parseAccountToDto(List<Account> accounts) {
        return accounts.stream()
                .map(AccountViewDTO::new).collect(Collectors.toList());
    }

    public static PaymentLogViewDTO parsePaymentLogToDto(Payment payment, Account srcAcc, Account destAcc, Client payer, Client recipient) {
        return new PaymentLogViewDTO(payment, srcAcc, destAcc, payer, recipient);
    }

    public static List<PaymentViewDTO> parsePaymentToDto(List<Payment> payments) {
        return payments.stream()
                .map(PaymentViewDTO::new).collect(Collectors.toList());
    }
}
