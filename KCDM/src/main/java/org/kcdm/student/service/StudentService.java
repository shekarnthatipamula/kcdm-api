package org.kcdm.student.service;

import org.kcdm.student.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> all();

    Student store(Student student);

    Student getStudent(Integer id);
}
