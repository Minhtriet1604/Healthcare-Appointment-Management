package com.clinic.service;

import com.clinic.model.User;
import com.clinic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt;
        }

        return Optional.empty();
    }

    public User register(User user) {
        return userRepository.save(user);
    }
}
