package org.ms.adsfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue
    private Integer patientId;
    private String patientNo;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @Lob
    private String address;
    private LocalDate dob;
}