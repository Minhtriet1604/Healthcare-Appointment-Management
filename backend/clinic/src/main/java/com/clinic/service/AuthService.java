package com.clinic.service;

import com.clinic.model.Role;
import com.clinic.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public User login(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setRole(Role.ADMIN);
            return user;
        }

        if ("doctor".equals(username) && "doctor".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setRole(Role.DOCTOR);
            return user;
        }

        return null;
    }
}
