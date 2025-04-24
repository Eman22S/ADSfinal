package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "surgery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "surgery_id")
    private Integer id;

    @Column(name = "surgeryNo")
    private String surgeryNo;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public Surgery(String surgeryNo, String name, String address, String phone) {
        this.surgeryNo = surgeryNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}