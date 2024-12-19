package com.cmm707.meditrack.appointment_management_service.repositoy;

import com.cmm707.meditrack.appointment_management_service.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for managing Appointment entities in MongoDB.
 */
@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(String doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> findByPatientId(String patientId);
}
