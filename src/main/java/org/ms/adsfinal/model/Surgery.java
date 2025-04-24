package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;
    private String surgeryNo;
    private String name;
    @Lob
    private String address;
    private String phone;

    public Surgery(String surgeryNo, String name, String address, String phone) {
        this.surgeryNo = surgeryNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}