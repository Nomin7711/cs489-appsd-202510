package edu.miu.nomin.jpa.dsas.repository;

import edu.miu.nomin.jpa.dsas.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
