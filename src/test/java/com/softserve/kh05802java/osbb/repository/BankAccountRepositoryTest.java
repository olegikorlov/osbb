package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.BankAccount;
import com.softserve.kh05802java.osbb.model.ServiceProvider;
import liquibase.pro.packaged.em;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BankAccountRepositoryTest {
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    BankAccountRepositoryTest(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    @Test
    void bankAccountCreationTest() {

        BankAccount bankAccount = new BankAccount();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setBankAccount(bankAccount);
        bankAccount.setServiceProvider(serviceProvider);

        bankAccountRepository.save(bankAccount);
        assertTrue(bankAccount.getId() > 0);

    }
}