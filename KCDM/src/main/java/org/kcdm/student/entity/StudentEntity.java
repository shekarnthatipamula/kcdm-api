package org.kcdm.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kcdm.Model;
import org.kcdm.student.model.Address;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "kc_student")
public class StudentEntity implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;

    @OneToOne(mappedBy = "student")
    @JoinColumn(name = "student_id")
    private AddressEntity address;
}
