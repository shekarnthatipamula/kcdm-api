package org.kcdm.users.dao;


import org.kcdm.ModelDao;
import org.kcdm.users.model.User;


public interface UserDao extends ModelDao<User,Integer>{
    User getActiveUser(String username);
}
