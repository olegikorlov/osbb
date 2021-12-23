package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
