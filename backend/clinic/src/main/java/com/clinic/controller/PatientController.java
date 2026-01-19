package com.example.healthcare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @GetMapping
    public String getPatients() {
        return "Danh sách bệnh nhân";
    }

    @PostMapping
    public String addPatient(@RequestBody String patient) {
        return "Thêm bệnh nhân thành công";
    }
}