package com.softserve.kh05802java.osbb.service.impl;

import com.softserve.kh05802java.osbb.exception.NullEntityReferenceException;
import com.softserve.kh05802java.osbb.model.Person;
import com.softserve.kh05802java.osbb.repository.PersonRepository;
import com.softserve.kh05802java.osbb.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person create(Person person) {
        if (person != null) {
            return repository.save(person);
        }
        throw  new NullEntityReferenceException("Person can't be \"null\"");
    }

    @Override
    public Person readById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NullEntityReferenceException("Person with " + id + " is not found")
        );
    }

    @Override
    public Person update(Person account) {
        if (account != null) {
            readById(account.getId());
            return repository.save(account);
        }
        throw  new NullEntityReferenceException("Person can't be \"null\"");
    }

    @Override
    public void delete(long id) {
        repository.delete(readById(id));
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

}
