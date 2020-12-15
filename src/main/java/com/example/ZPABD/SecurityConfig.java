package com.example.ZPABD;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails guest = User.withDefaultPasswordEncoder()
                .username("guest")
                .password("guestPass")
                .roles("GUEST")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("userPass")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("adminPass")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(guest, user, admin);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "api/employees/allEmplo").permitAll()
                .antMatchers(HttpMethod.DELETE, "api/employees/deleteEmplo").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "api/employees/updateEmplo").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "api/employees/byId").hasRole("USER")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

    }
}
