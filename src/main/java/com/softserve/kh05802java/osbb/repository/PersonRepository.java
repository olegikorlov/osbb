package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
