package com.payment.repository.payment;

import com.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, BigInteger>{

}
