package org.ms.adsfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dentist {
    @Id
    @GeneratedValue
    private Integer dentistId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String specialization;
}