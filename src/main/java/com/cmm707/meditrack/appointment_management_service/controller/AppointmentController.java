package com.cmm707.meditrack.appointment_management_service.controller;

import com.cmm707.meditrack.appointment_management_service.model.Appointment;
import com.cmm707.meditrack.appointment_management_service.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST controller for managing appointments.
 */
@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        log.info("API call to create a new appointment");
        return ResponseEntity.ok(appointmentService.createAppointment(appointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable String id, @RequestBody Appointment appointment) {
        log.info("API call to update appointment with ID: {}", id);
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
        log.info("API call to fetch appointment with ID: {}", id);
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(
            @PathVariable String doctorId,
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        log.info("API call to fetch appointments for doctor ID: {}", doctorId);
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId, start, end));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable String patientId) {
        log.info("API call to fetch appointments for patient ID: {}", patientId);
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patientId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable String id) {
        log.info("API call to delete appointment with ID: {}", id);
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
