package org.kcdm.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kcdm.Model;
import org.kcdm.student.model.Student;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "kc_student_address")
public class AddressEntity implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String hno;
    @Column
    private String street;
    @Column
    private String village;
    @Column
    private String town;
    @Column
    private String mandal;
    @Column
    private String district;
    @Column
    private String state;
    @Column
    private String pincode;

    @OneToOne
    private StudentEntity student;
}
