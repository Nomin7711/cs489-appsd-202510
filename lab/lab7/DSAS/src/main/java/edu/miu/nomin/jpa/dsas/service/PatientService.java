package edu.miu.nomin.jpa.dsas.service;

import edu.miu.nomin.jpa.dsas.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient>   getAllPatients();
    Patient         getPatientById(int id);
    Patient         addNewPatient(Patient newPatient);
    Patient         updatePatient(int id, Patient updatedPatient);
    void            deletePatient(int id);
}
