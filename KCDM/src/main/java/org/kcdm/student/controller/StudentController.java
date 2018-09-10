package org.kcdm.student.controller;

import org.kcdm.security.model.SecurityUserDetails;
import org.kcdm.student.model.Student;
import org.kcdm.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RestController
@RequestMapping("/v1/students/")
public class StudentController {

    @Inject
    @Named("studentService")
    private StudentService studentService;

    @GetMapping
    //@PreAuthorize("hasAnyRole('STUDENT')")
    //public List<Student> students(final @AuthenticationPrincipal SecurityUserDetails userDetails) {
    public List<Student> students() {
        return this.studentService.all();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole(STUDENT)")
    public Student add(@RequestBody Student student) {

        return this.studentService.store(student);
    }

    @GetMapping(value ="{id}")
    @PreAuthorize("hasAnyRole(STUDENT)")
    public Student getStudent(final @AuthenticationPrincipal SecurityUserDetails userDetails,
                              @PathVariable("id")Integer id){
        return studentService.getStudent(id);
    }
}
