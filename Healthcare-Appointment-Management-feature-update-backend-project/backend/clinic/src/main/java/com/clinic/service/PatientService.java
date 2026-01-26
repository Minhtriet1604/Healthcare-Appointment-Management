package com.clinic.service;

import com.clinic.model.Patient;
import com.clinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
