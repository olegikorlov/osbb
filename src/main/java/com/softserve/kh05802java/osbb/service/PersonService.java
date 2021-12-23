package com.softserve.kh05802java.osbb.service;

import com.softserve.kh05802java.osbb.model.Person;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface PersonService {
    Person create(Person person);

    Person readById(long id);

    Person update(Person person);

    void delete(long id);

    List<Person> getAll();

}
