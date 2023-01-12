package com.example.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            auth.inMemoryAuthentication().withUser("User").password(encoder.encode("password")).roles("USER");
            auth.inMemoryAuthentication().withUser("Admin").password(encoder.encode("password")).roles("ADMIN");
            auth.inMemoryAuthentication().withUser("Noname").password(encoder.encode("100")).roles("USER");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().antMatchers("/persons/by-person", "/persons/by-city").permitAll()
                    .and()
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .formLogin();
        }

}


