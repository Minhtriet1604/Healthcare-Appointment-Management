package com.example.healthcare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @GetMapping
    public String getDoctors() {
        return "Danh sách bác sĩ";
    }

    @PostMapping
    public String addDoctor(@RequestBody String doctor) {
        return "Thêm bác sĩ thành công";
    }
}