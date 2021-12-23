package com.softserve.kh05802java.osbb;

import com.softserve.kh05802java.osbb.model.User;
import com.softserve.kh05802java.osbb.service.UserService;
import com.softserve.kh05802java.osbb.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService accountService, RoleService roleService, PasswordEncoder passwordEncoder) {
        return args -> {
            User account = new User("test@test.com", "Oleg", "Orlov");
            account.setRole(roleService.readById(2));
            account.setPassword(passwordEncoder.encode("12345"));
            accountService.create(account);
            log.info("" + account);
//            if (true) return;
        };
    }
}
