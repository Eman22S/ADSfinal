package org.ms.adsfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue
    private Integer billId;

    @ManyToOne
    private Patient patient;

    private BigDecimal amount;
    private boolean paid;
}