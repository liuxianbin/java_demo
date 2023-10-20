package cn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> {
            authorize
                    .requestMatchers("/html/**").permitAll()
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/login2").permitAll()
                    .anyRequest().authenticated();
        });

        http.formLogin(
                form -> {
                    form.loginPage("/login");
                }
        );

        http.exceptionHandling(config -> {
            config.accessDeniedHandler((request, response, accessDeniedException) -> {
                response.setStatus(400);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("没有权限...");
            });
        });
        return http.build();
    }
}