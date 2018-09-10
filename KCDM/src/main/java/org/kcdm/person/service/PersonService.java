package org.kcdm.person.service;



import org.kcdm.person.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> all();

    Person store(Person person);

    Person getPerson(Integer id);
}
