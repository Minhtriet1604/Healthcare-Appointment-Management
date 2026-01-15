package com.clinic.controller;

import com.clinic.dto.ApiResponse;
import com.clinic.model.Doctor;
import com.clinic.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ApiResponse<List<Doctor>> getAll() {
        return new ApiResponse<>(200, "Success", doctorService.findAll());
    }

    @PostMapping
    public ApiResponse<Doctor> create(@RequestBody Doctor doctor) {
        return new ApiResponse<>(201, "Created", doctorService.save(doctor));
    }
}