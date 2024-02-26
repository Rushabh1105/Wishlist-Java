package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user details from the database or any other user store
        // For simplicity, let's create a UserDetails object with hardcoded values
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username("user")
                    .password("{noop}password") // {noop} indicates plaintext password (no encoding)
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}