package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}