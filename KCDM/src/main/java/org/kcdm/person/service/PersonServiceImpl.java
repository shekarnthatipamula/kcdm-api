package org.kcdm.person.service;


import org.kcdm.person.dao.PersonDao;
import org.kcdm.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> all() {
        return personDao.all();
    }

    @Override
    @Transactional
    public Person store(Person person) {
        return personDao.store(person);
    }

    @Override
    public Person getPerson(Integer id) {
        return  personDao.getPerson(id);
    }
}
