package org.kcdm.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/v1/students/**").hasRole("STUDENT")//.authenticated()
                .antMatchers("/v2/students/**").hasRole("STUDENT")//.authenticated()
                .antMatchers("/v1/persons/**").hasRole("PERSON")//.authenticated()
                .and()
                .httpBasic();
    }

   @Inject
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//      auth.userDetailsService(userDetailsService).passwordEncoder(getEncoder());
//       auth.inMemoryAuthentication()
//               .withUser("shekhar").password("s123").roles("STUDENT")
//               .and()
//               .withUser("siva").password("s123").roles("PERSON");
    }
}
