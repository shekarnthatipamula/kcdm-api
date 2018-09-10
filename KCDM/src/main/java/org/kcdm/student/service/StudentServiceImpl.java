package org.kcdm.student.service;

import org.kcdm.student.dao.StudentDao;
import org.kcdm.student.model.Student;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Inject
    @Named("studentDao")
    private StudentDao studentDao;

    @Override
    public List<Student> all() {
        return studentDao.all();
    }

    @Override
    public Student store(Student student) {
        return studentDao.store(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentDao.getStudent(id);
    }
}
