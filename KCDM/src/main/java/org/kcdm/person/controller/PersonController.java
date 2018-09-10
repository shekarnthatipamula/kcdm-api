package org.kcdm.person.controller;

import org.kcdm.person.model.Person;
import org.kcdm.person.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    @Inject
    @Named("personService")
    private PersonService personService;

    @GetMapping
    public List<Person> persons() {
        return this.personService.all();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person add(@RequestBody Person person) {
        return this.personService.store(person);
    }

    @GetMapping(value ="/{id}")
    public Person getPerson(@PathVariable("id")Integer id){
        return personService.getPerson(id);
    }
}
