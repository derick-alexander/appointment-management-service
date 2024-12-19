package com.cmm707.meditrack.appointment_management_service.service;

import com.cmm707.meditrack.appointment_management_service.model.Appointment;

import com.cmm707.meditrack.appointment_management_service.repositoy.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing appointments.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        log.info("Creating new appointment for patient ID: {}", appointment.getPatientId());
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(String id, Appointment appointment) {
        log.info("Updating appointment with ID: {}", id);
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            appointment.setId(id); // Ensure the same record is updated.
            return appointmentRepository.save(appointment);
        } else {
            log.warn("Appointment not found with ID: {}", id);
            throw new RuntimeException("Appointment not found");
        }
    }

    @Override
    public Appointment getAppointmentById(String id) {
        log.info("Fetching appointment with ID: {}", id);
        return appointmentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Appointment not found with ID: {}", id);
                    return new RuntimeException("Appointment not found");
                });
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(String doctorId, LocalDateTime start, LocalDateTime end) {
        log.info("Fetching appointments for doctor ID: {} between {} and {}", doctorId, start, end);
        return appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, start, end);
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(String patientId) {
        log.info("Fetching appointments for patient ID: {}", patientId);
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public void deleteAppointment(String id) {
        log.info("Deleting appointment with ID: {}", id);
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
