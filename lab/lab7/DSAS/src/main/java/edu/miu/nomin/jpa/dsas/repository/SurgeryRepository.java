package edu.miu.nomin.jpa.dsas.repository;

import edu.miu.nomin.jpa.dsas.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
