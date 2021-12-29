package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}