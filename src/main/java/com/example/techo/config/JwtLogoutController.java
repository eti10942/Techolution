package com.example.techo.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtLogoutController {

    @PostMapping("/logout")
    public void logout() {
        SecurityContextHolder.clearContext();
        // Perform any additional logout operations if needed
        System.out.print("LoggedOut");
    }
}
