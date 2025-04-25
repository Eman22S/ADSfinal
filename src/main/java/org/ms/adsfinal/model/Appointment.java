package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

    @Column(name = "status")
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