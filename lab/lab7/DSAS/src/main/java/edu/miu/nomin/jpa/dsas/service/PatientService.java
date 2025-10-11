package edu.miu.nomin.jpa.dsas.service;

import edu.miu.nomin.jpa.dsas.dto.PatientDTO;
import edu.miu.nomin.jpa.dsas.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient>   getAllPatients();
    List<Patient> findAllPatientsSortedByName();
    Patient         getPatientById(int id);
    Patient         addNewPatient(Patient newPatient);
    Patient updatePatient(int id, Patient updatedPatient);
    void            deletePatient(int id);
    List<Patient> searchPatients(String searchString);
}
