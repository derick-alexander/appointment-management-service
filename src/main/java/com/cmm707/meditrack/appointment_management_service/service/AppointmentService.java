package com.cmm707.meditrack.appointment_management_service.service;

import com.cmm707.meditrack.appointment_management_service.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service interface defining methods for managing appointments.
 */
public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(String id, Appointment appointment);
    Appointment getAppointmentById(String id);
    List<Appointment> getAppointmentsByDoctor(String doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> getAppointmentsByPatient(String patientId);
    void deleteAppointment(String id);
}
