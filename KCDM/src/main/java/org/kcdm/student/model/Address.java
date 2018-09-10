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
public class Address implements Model {
    private Integer id;
    private String hno;
    private String street;
    private String village;
    private String town;
    private String mandal;
    private String district;
    private String state;
    private String pincode;
}
