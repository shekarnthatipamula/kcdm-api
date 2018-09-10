package org.kcdm.security.service;


import org.kcdm.security.model.SecurityUserDetails;
import org.kcdm.users.dao.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service("userDetailsService")
public class KCUserDetailsService implements UserDetailsService{
    @Inject
    @Named("userDao")
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     //   User user=userDao.getActiveUser(username);
      //  GrantedAuthority authority=new SimpleGrantedAuthority(user.getRole());
      //  SecurityUserDetails securityUserDetails=new SecurityUserDetails(user);//
      //  UserDetails userDetails=(UserDetails)new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), Arrays.asList(authority));
        return new SecurityUserDetails(userDao.getActiveUser(username));
      //  return userDetails;
    }
}
