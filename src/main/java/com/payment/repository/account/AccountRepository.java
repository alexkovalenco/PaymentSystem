package com.payment.repository.account;

import com.payment.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, BigInteger>{
    List<Account> findAllByClientId(BigInteger clientId);
}
