package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Bill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BillRepositoryTest {
    private final BillRepository billRepository;

    @Autowired
    BillRepositoryTest(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Test
    void billRepositoryCreationTest() {
        Bill bill = new Bill();
        bill.setAmount(BigDecimal.valueOf(1000000));

        billRepository.save(bill);

        assertFalse(bill.getAmount() == null || bill.getId() < 1);
    }
}