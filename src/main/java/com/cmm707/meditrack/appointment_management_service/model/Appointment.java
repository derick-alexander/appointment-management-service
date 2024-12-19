package com.cmm707.meditrack.appointment_management_service.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Entity class representing appointment details stored in the database.
 */
@Data
@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;

    @NotBlank
    private String patientId;

    @NotBlank
    private String doctorId;

    @Future
    private LocalDateTime appointmentDate;

    @NotBlank
    private String status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
