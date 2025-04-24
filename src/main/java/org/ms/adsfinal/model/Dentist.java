package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dentist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentist_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "specialization")
    private String specialization;


    public Dentist(String firstName, String lastName, String phone, String email, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.specialization = specialization;
    }
}