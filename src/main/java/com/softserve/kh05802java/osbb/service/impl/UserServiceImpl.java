package com.softserve.kh05802java.osbb.service.impl;

import com.softserve.kh05802java.osbb.exception.NullEntityReferenceException;
import com.softserve.kh05802java.osbb.model.User;
import com.softserve.kh05802java.osbb.repository.UserRepository;
import com.softserve.kh05802java.osbb.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public User create(User account) {
        if (account != null) {
            return userRepository.save(account);
        }
        throw new NullEntityReferenceException("Account can't be \"null\"");
    }

    @Override
    public User readById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NullEntityReferenceException("Account with " + id + " is not found")
        );
    }

    @Override
    public User update(User account) {
        if (account != null) {
            readById(account.getId());
            return userRepository.save(account);
        }
        throw new NullEntityReferenceException("Account can't be \"null\"");
    }

    @Override
    public void delete(long id) {
        userRepository.delete(readById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User account = userRepository.findByLogin(username);
        if (account != null) {
            return account;
        }
        throw new UsernameNotFoundException("User not found!");
    }
}
