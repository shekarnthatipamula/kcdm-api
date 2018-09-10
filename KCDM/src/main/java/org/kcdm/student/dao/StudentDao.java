package org.kcdm.student.dao;

import org.kcdm.student.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> all();

    Student store(Student student);

    Student getStudent(Integer id);
}
