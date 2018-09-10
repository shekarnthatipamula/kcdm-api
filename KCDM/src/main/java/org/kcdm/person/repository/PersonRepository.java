package org.kcdm.person.repository;

import org.kcdm.person.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "/persons")
@Repository("personRepository")
public interface PersonRepository extends PagingAndSortingRepository<Person,Integer>{
}
