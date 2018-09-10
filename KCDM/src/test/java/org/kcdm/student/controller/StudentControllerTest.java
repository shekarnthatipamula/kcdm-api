package org.kcdm.student.controller;

import org.junit.Assert;
import org.junit.Test;
import org.kcdm.AbstractSpringMvcTest;
import org.kcdm.student.dao.StudentDao;
import org.kcdm.student.model.Address;
import org.kcdm.student.model.Student;
import org.kcdm.student.service.StudentService;
import org.springframework.http.MediaType;

import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StudentControllerTest extends AbstractSpringMvcTest {



    @Test
    public void students() throws Exception {
        mockMvc.perform(get("/v1/students/")
                .with(httpBasic(masterData.getCityWatchUser().getUsername(),"m123"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Shekhar"))
                .andExpect(jsonPath("$[0].age").value(24));
    }

    @Test
    public void getStudent() throws Exception {
        mockMvc.perform(get("/v1/students/{id}",masterData.getCityWatchStudent().getId().toString())
                .with(httpBasic(masterData.getCityWatchUser().getUsername(),"m123"))
                //.with(httpBasic("tarun","t123"))
                //.param("id",masterData.getCityWatchStudent().getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void saveStudent() throws Exception {
        Student student=Student.builder()
                .age(25)
                .name("Kiran").build();
        Address address=Address.builder()
                .hno("2-98 A")
                .street("Newtown")
                .village("motlampally")
                .town("atmakur")
                .mandal("atmakur")
                .district("Wanaparthy")
                .state("Telangana")
                .pincode("509131")
                .build();
        student.setAddress(address);
        mockMvc.perform(post("/v1/students/")
                .with(httpBasic(masterData.getCityWatchUser().getUsername(),"m123"))
                .content(json.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

}