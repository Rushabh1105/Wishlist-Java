package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AuthService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignupRequest request) {
        if (authService.signUp(request.getUsername(), request.getPassword())) {
            return "User registered successfully";
        }
        return "User already exists";
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody SigninRequest request) {
        if (authService.signIn(request.getUsername(), request.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    static class SignupRequest {
        private String username;
        private String password;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

        // Getters and setters
        
    }

    static class SigninRequest {
        private String username;
        private String password;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

        // Getters and setters
        
    }
}