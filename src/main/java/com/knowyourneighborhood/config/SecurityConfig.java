package com.knowyourneighborhood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.knowyourneighborhood.auth.UserDetailsServiceImpl;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("At Authen configure");
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    
	// Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("At Authority configure");
        http
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login_error")
                    .permitAll()
                    .defaultSuccessUrl("/viewStore", true)
                .and()
                .csrf()
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/favicon.*").permitAll()
                    .antMatchers(HttpMethod.GET, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/viewStore").hasRole("VIEW_STORE")
                    .antMatchers(HttpMethod.GET, "/search").hasRole("VIEW_STORE")
                    .antMatchers(HttpMethod.GET, "/registerStore").hasRole("ADD_STORE")
                    .antMatchers(HttpMethod.POST, "/registerStore").hasRole("ADD_STORE")
                    .antMatchers(HttpMethod.PUT, "/edit").hasRole("ADD_STORE")
                    .antMatchers(HttpMethod.DELETE, "/delete").hasRole("ADD_STORE")
                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");
    }

}
