package edu.miu.nomin.jpa.dsas.repository;

import edu.miu.nomin.jpa.dsas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
