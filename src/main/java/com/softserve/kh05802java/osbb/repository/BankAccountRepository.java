package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}