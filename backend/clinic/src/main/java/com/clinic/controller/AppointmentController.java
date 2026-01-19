package com.example.healthcare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @GetMapping
    public String getAllAppointments() {
        return "Danh sách lịch hẹn";
    }

    @PostMapping
    public String createAppointment(@RequestBody String appointment) {
        return "Đã tạo lịch hẹn";
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable int id) {
        return "Đã xóa lịch hẹn ID = " + id;
    }
}