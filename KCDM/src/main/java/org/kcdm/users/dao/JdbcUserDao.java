package org.kcdm.users.dao;

import org.kcdm.ModelDaoSuport;
import org.kcdm.users.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class JdbcUserDao extends ModelDaoSuport implements UserDao {

    @Override
    protected void initDao() {
        //Todo
    }

    @Override
    public User getActiveUser(String username) {
        User user= User.builder().build();
        short enabled=1;
        List<User>  users=namedParameterJdbcTemplate.query("SELECT * FROM users WHERE username=:username and enabled=:enabled",new MapSqlParameterSource()
                .addValue("username",username).addValue("enabled",enabled), new BeanPropertyRowMapper<User>(User.class));
        if(!users.isEmpty()) {
            user = users.get(0);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User model) {
        return null;
    }

    @Override
    public User update(User model) {
        return null;
    }

    @Override
    public User findOne(Integer integer) {
        return null;
    }
}
