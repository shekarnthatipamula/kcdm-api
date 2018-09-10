package org.kcdm.student.repository;

import org.kcdm.student.entity.StudentEntity;
import org.kcdm.student.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "/students")
@Repository("studentRepository")
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity,Integer>{
}
