package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Contact;
import com.softserve.kh05802java.osbb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ContactRepositoryTest {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    ContactRepositoryTest(ContactRepository contactRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Test
    void addNewContactToUserTest() {
        User actual = userRepository.findByLogin("info@olegorlov.com");
        if (actual == null) {
            User user = new User();
            user.setFirstName("Oleg");
            user.setLastName("Orlov");
            user.setLogin("info@olegorlov.com");
            user.setPassword(passwordEncoder.encode("12345"));
            user.setRole(roleRepository.getById(2L));
            userRepository.save(user);
            actual = userRepository.findByLogin("info@olegorlov.com");
        }
        assertTrue(actual.getId() > 0);

        Contact contact = new Contact();
        contact.setUser(actual);
        contact.setValue("380501234567");
        contact.setVerified(true);
        contactRepository.save(contact);
        assertTrue(contact.getId() > 0);
    }
}