package org.ms.adsfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Surgery {
    @Id
    @GeneratedValue
    private Integer surgeryId;
    private String surgeryNo;
    private String name;
    @Lob
    private String address;
    private String phone;
}