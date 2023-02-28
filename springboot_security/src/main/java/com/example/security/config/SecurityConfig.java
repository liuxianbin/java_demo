package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("uname")
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successForwardUrl("/doSuccess")
                .failureForwardUrl("/doError")

        ;
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();

    }
}
