package com.clinic.controller;

import com.clinic.dto.ApiResponse;
import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ApiResponse<List<Patient>> getAll() {
        return new ApiResponse<>(200, "Success", patientService.findAll());
    }

    @PostMapping
    public ApiResponse<Patient> create(@RequestBody Patient patient) {
        return new ApiResponse<>(201, "Created", patientService.save(patient));
    }
}