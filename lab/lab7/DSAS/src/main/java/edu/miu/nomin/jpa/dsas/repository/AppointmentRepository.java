package edu.miu.nomin.jpa.dsas.repository;

import edu.miu.nomin.jpa.dsas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
