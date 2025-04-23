package org.ms.adsfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue
    private Integer appointmentId;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Surgery surgery;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
}