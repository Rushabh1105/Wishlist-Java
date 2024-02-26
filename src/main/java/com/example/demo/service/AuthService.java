package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.modal.MyUser;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


	public boolean signUp(String username, String password) {
        if (userRepository.findByUsername(username) == null) {
            MyUser myUser = new MyUser();
            myUser.setUsername(username);
            myUser.setPassword(passwordEncoder.encode(password));
            userRepository.save(myUser);
            return true;
        }
        return false;
    }

    public boolean signIn(String username, String password) {
        MyUser myUser = userRepository.findByUsername(username);
        if (myUser != null && passwordEncoder.matches(password, myUser.getPassword())) {
            return true;
        }
        return false;
    }
}
