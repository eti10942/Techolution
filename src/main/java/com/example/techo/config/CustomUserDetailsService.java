package com.example.techo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Add your own logic to retrieve the user details based on the username
        // For demonstration purposes, we will use a predefined username and password
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password("admin123") // Use plaintext password directly
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}







