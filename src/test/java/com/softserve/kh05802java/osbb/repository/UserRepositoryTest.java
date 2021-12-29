package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(roleRepository);
        assertNotNull(userRepository);
        assertNotNull(passwordEncoder);
    }

    @Test
    void findByLogin() {
        User user = new User();
        user.setFirstName("Oleg");
        user.setLastName("Orlov");
        user.setLogin("info@olegorlov.com");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setRole(roleRepository.getById(2L));

        User expected = userRepository.save(user);
        User actual = userRepository.findByLogin("info@olegorlov.com");

        assertTrue(user.getId() > 0);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

}
