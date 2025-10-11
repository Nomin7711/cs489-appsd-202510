package edu.miu.nomin.jpa.dsas.mapper;

import edu.miu.nomin.jpa.dsas.dto.*;
import edu.miu.nomin.jpa.dsas.model.*;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        if (patient == null) return null;

        AddressDTO addressDTO = null;
        if (patient.getAddress() != null) {
            Address address = patient.getAddress();
            addressDTO = new AddressDTO(
                    address.getStreet(),
                    address.getCity(),
                    address.getState(),
                    address.getZipCode()
            );
        }

        return new PatientDTO(
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                addressDTO
        );
    }
}
