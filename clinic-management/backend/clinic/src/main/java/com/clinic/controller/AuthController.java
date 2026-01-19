package com.example.healthcare.controller;

import com.example.healthcare.dto.LoginRequest;
import com.example.healthcare.dto.LoginResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /**
     * API đăng nhập
     * @param request dữ liệu đăng nhập từ client
     * @return LoginResponse
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        // 1️⃣ Kiểm tra dữ liệu đầu vào
        if (request.getUsername() == null || request.getPassword() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(
                            false,
                            "Thiếu username hoặc password",
                            null
                    ));
        }

        // 2️⃣ Demo dữ liệu (chưa dùng DB)
        if ("admin".equals(request.getUsername())
                && "123".equals(request.getPassword())) {

            return ResponseEntity.ok(
                    new LoginResponse(
                            true,
                            "Đăng nhập thành công",
                            "ADMIN"
                    )
            );
        }

        if ("doctor".equals(request.getUsername())
                && "123".equals(request.getPassword())) {

            return ResponseEntity.ok(
                    new LoginResponse(
                            true,
                            "Đăng nhập thành công",
                            "DOCTOR"
                    )
            );
        }

        if ("patient".equals(request.getUsername())
                && "123".equals(request.getPassword())) {

            return ResponseEntity.ok(
                    new LoginResponse(
                            true,
                            "Đăng nhập thành công",
                            "PATIENT"
                    )
            );
        }

        // 3️⃣ Sai thông tin đăng nhập
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponse(
                        false,
                        "Sai username hoặc password",
                        null
                ));
    }

    /**
     * API đăng xuất
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Đăng xuất thành công");
    }

    /**
     * API lấy thông tin user hiện tại
     */
    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser() {
        return ResponseEntity.ok("Thông tin người dùng hiện tại");
    }
}
