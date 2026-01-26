package com.clinic.controller;

import com.clinic.dto.LoginRequest;
import com.clinic.dto.LoginResponse;
import com.clinic.model.User;
import com.clinic.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * API đăng nhập
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        // 1️⃣ Kiểm tra dữ liệu đầu vào
        if (request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(
                            false,
                            "Thiếu email hoặc password",
                            null
                    ));
        }

        // 2️⃣ Xác thực với database
        var userOpt = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok(
                    new LoginResponse(
                            true,
                            "Đăng nhập thành công",
                            user.getRole().name()
                    )
            );
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(
                            false,
                            "Sai email hoặc password",
                            null
                    ));
        }
    }

    /**
     * API đăng ký
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = authService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    /**
     * API đăng xuất (demo)
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Đăng xuất thành công");
    }

    /**
     * API lấy thông tin user hiện tại (demo)
     */
    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser() {
        return ResponseEntity.ok("Thông tin người dùng hiện tại");
    }
}
