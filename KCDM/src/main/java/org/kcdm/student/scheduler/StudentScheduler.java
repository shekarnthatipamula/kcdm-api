package org.kcdm.student.scheduler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/studentScheduler")
public class StudentScheduler {

    public void displayStudents(){
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());

    }
}
