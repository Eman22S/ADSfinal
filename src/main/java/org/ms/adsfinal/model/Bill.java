package org.ms.adsfinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @ManyToOne
    private Patient patient;

    private BigDecimal amount;
    private boolean paid;

    public Bill(Patient patient, BigDecimal amount, boolean paid) {
        this.patient = patient;
        this.amount = amount;
        this.paid = paid;
    }
}