package org.kcdm.student.dao;

import org.kcdm.ModelDaoSuport;
import org.kcdm.student.model.Address;
import org.kcdm.student.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class JdbcStudentDao extends ModelDaoSuport implements StudentDao {

    private SimpleJdbcInsert simpleJdbcInsertStudent;
    private SimpleJdbcInsert simpleJdbcInsertStudentAddress;

    @Override
    protected void initDao() {
        this.simpleJdbcInsertStudent = new SimpleJdbcInsert(getJdbcTemplate())
                .withTableName("kc_student")
                .usingColumns(
                        "name",
                        "age"
                ).usingGeneratedKeyColumns("id");
        this.simpleJdbcInsertStudentAddress = new SimpleJdbcInsert(getJdbcTemplate())
                .withTableName("kc_student_address")
                .usingColumns(
                        "hno",
                        "street",
                        "village",
                        "town",
                        "mandal",
                        "district",
                        "state",
                        "pincode",
                        "student_id"
                ).usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Student> all() {
        final String sql="SELECT * FROM kc_student";
        return namedParameterJdbcTemplate.query(sql,new EmptySqlParameterSource(),
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public Student store(Student student) {
        final SqlParameterSource parameterSource =  new MapSqlParameterSource()
                .addValue("age", student.getAge())
                .addValue("name",student.getName());
        student.setId(simpleJdbcInsertStudent.executeAndReturnKey(parameterSource).intValue());
        Address addresss=student.getAddress();
        if (addresss!=null&&student.getId()!=null){
            final SqlParameterSource addressParameterSource =  new MapSqlParameterSource()
                    .addValue("hno", addresss.getHno())
                    .addValue("street", addresss.getStreet())
                    .addValue("village", addresss.getVillage())
                    .addValue("town", addresss.getTown())
                    .addValue("mandal", addresss.getMandal())
                    .addValue("district", addresss.getDistrict())
                    .addValue("state", addresss.getState())
                    .addValue("pincode",addresss.getPincode())
                    .addValue("student_id",student.getId());
            addresss.setId(simpleJdbcInsertStudentAddress.executeAndReturnKey(addressParameterSource).intValue());
        }

        return student;
    }
    @Override
    public Student getStudent(Integer id) {
        final String sql="SELECT * FROM kc_student where id=:id";
        return namedParameterJdbcTemplate.queryForObject(sql,new MapSqlParameterSource().addValue("id",id),
                new BeanPropertyRowMapper<Student>(Student.class));
    }
}
