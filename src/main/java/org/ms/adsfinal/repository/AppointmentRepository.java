package org.ms.adsfinal.repository;

import org.ms.adsfinal.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {}
