package com.clinic.controller;

import com.clinic.model.Appointment;
import com.clinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable Long id,
                              @RequestBody Appointment appointment) {
        appointment.setId(id);
        return appointmentService.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}