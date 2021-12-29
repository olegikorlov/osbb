package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {
    private final PersonRepository personRepository;

    @Autowired
    PersonRepositoryTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @Test
    void findLastName() {
        Person person = new Person();
        person.setFirstName("Mikola");
        person.setMiddleName("Yanovich");
        person.setLastName("Azarov");
        Person actual = personRepository.save(person);
        Person expected = personRepository.findByLastName("Azarov");
        assertNotNull(expected);
        assertEquals(expected, actual);
    }
    
    @Test
    void save() {
        Person person = new Person();
        person.setFirstName("Klavdija");
        person.setLastName("Shulzenko");
        Person actual = personRepository.save(person);
        assertNotNull(actual);
    }
    
    @Test
    void update() {
        Person actual = personRepository.findByLastName("Shulzenko");
        if(actual == null) {
            Person person = new Person();
            person.setLastName("Shulzenko");
            personRepository.save(person);
            actual = personRepository.findByLastName("Shulzenko");
        }
        actual.setLastName("Kuri");
        Person expected = personRepository.save(actual);
        assertNotNull(expected);
        assertEquals(expected, actual);
    }

    @Test
    void delete() {

    }
}