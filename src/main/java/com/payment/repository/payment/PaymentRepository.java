package com.payment.repository.payment;

import com.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, BigInteger>{
    List<Payment> findAllBySourceAccIdAndDestAccId(BigInteger sourceAccId, BigInteger destAccId);
}
