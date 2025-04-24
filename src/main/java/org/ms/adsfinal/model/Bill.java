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
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bill_id")
    private Integer billId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private BigDecimal amount;
    private boolean paid;

    public Bill(Patient patient, BigDecimal amount, boolean paid) {
        this.patient = patient;
        this.amount = amount;
        this.paid = paid;
    }
}