package org.kcdm.student.model;

import org.kcdm.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student implements Model{
    private Integer id;
    private String name;
    private Integer age;
    private Address address;
}
