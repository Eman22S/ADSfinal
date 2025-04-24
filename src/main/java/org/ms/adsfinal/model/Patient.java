package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String patientNo;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @Lob
    private String address;
    private LocalDate dob;

    public Patient(String patientNo, String firstName, String lastName, String phone, String email, LocalDate dob, String address) {
        this.patientNo = patientNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }
}