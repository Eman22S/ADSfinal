package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Appointment(Dentist dentist, Patient patient, Surgery surgery, LocalDate appointmentDate, LocalTime appointmentTime, String status) {
        this.dentist = dentist;
        this.patient = patient;
        this.surgery = surgery;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.appointmentTime = appointmentTime;
    }
}