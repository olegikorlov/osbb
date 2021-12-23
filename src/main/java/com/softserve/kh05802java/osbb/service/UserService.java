package com.softserve.kh05802java.osbb.service;

import com.softserve.kh05802java.osbb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface UserService extends UserDetailsService {
    User create(User account);

    User readById(long id);

    User update(User account);

    void delete(long id);

    List<User> getAll();

}
