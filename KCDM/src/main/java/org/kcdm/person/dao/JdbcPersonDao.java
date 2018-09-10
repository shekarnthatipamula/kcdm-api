package org.kcdm.person.dao;

import org.kcdm.ModelDaoSuport;
import org.kcdm.person.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDao")
public class JdbcPersonDao extends ModelDaoSuport implements PersonDao {

    private SimpleJdbcInsert simpleJdbcInsertStudent;

    @Override
    protected void initDao() {
        this.simpleJdbcInsertStudent = new SimpleJdbcInsert(getJdbcTemplate())
                .withTableName("person")
                .usingColumns(
                        "first_name",
                        "last_name",
                        "age"
                ).usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Person> all() {
        final String sql="SELECT * FROM person";
        return namedParameterJdbcTemplate.query(sql,new EmptySqlParameterSource(),
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public Person store(Person person) {
        final SqlParameterSource parameterSource =  new MapSqlParameterSource()
                .addValue("first_name", person.getFirstName())
                .addValue("last_name", person.getLastName())
                .addValue("age",person.getAge());
        person.setId(simpleJdbcInsertStudent.executeAndReturnKey(parameterSource).intValue());
        return person;
    }

    @Override
    public Person getPerson(Integer id) {
        final String sql="SELECT * FROM person where id=:id";
        return namedParameterJdbcTemplate.queryForObject(sql,new MapSqlParameterSource().addValue("id",id),
                new BeanPropertyRowMapper<Person>(Person.class));
    }
}
