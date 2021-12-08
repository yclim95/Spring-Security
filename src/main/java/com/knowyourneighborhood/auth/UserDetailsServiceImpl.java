package com.knowyourneighborhood.auth;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.knowyourneighborhood.UserRepository;
import com.knowyourneighborhood.model.Role;
import com.knowyourneighborhood.model.User;


@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl() {
    }
    
    // Get UserDetails at login  & Return userDetails
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("email " + email + " is not valid. Please re-enter.");
        }
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
        
        String[] roleNames= user.getRoles().stream().map(Role::getRoleType).toArray(String[]::new);
        
        System.out.println("Role Name is "+roleNames);
        return userBuilder.username(user.getEmail()) 
                        .password(user.getPassword())
                        .roles(roleNames)
                        .build();
        // System.out.println("Login password" +user.getPassword());
        // System.out.println("comapre: " + passwordEncoder.matches("john123456", user.getPassword()));
        // System.out.println("User details "+loginuser.toString());
    }
}
