package org.kcdm.person.dao;

import org.kcdm.person.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> all();

    Person store(Person person);

    Person getPerson(Integer id);
}
