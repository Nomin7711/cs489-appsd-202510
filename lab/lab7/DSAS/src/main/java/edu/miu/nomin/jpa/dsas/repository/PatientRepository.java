package edu.miu.nomin.jpa.dsas.repository;

import edu.miu.nomin.jpa.dsas.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p ORDER BY p.name ASC")
    List<Patient> findAllPatientsSortedByName();
    @Query("SELECT p FROM Patient p " +
            "WHERE LOWER(p.name) LIKE CONCAT('%', LOWER(:searchString), '%') " +
            "   OR LOWER(p.email) LIKE CONCAT('%', LOWER(:searchString), '%') " +
            "   OR LOWER(p.phone) LIKE CONCAT('%', LOWER(:searchString), '%')")
    List<Patient> searchPatients(@Param("searchString") String searchString);
}
