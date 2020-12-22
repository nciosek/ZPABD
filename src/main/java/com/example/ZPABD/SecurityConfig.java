package com.example.ZPABD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }*/

    /* LAB 3 */
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
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "api/employees/allEmplo").permitAll()
                .antMatchers(HttpMethod.DELETE, "api/employees/deleteEmplo").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "api/employees/updateEmplo").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "api/employees/byId").hasRole("USER")
                .antMatchers(HttpMethod.GET, "api/department/allDept").permitAll()
                .antMatchers(HttpMethod.GET,"api/department/byId").hasRole("USER")
                .antMatchers(HttpMethod.POST, "api/department/addDept").permitAll()
                .antMatchers(HttpMethod.DELETE, "api/department/deleteDept").permitAll()
                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and().csrf().disable();

    }
}
