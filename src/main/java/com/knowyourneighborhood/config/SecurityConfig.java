package com.knowyourneighborhood.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login_error")
                    .permitAll()
                    .defaultSuccessUrl("/stores", true)
                .and()
                .csrf()
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/favicon.*").permitAll()
                    .antMatchers(HttpMethod.GET, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/stores").hasRole("VIEW_STORE")
                    .antMatchers(HttpMethod.POST, "/stores").hasRole("ADD_STORE")
                    .antMatchers(HttpMethod.PUT, "/stores").hasRole("ADD_STORE")
                    .antMatchers(HttpMethod.DELETE, "/stores").hasRole("ADD_STORE")
                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");
    }

}
