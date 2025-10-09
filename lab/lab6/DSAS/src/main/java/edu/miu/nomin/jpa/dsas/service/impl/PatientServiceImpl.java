package edu.miu.nomin.jpa.dsas.service.impl;

import edu.miu.nomin.jpa.dsas.model.Patient;
import edu.miu.nomin.jpa.dsas.repository.PatientRepository;
import edu.miu.nomin.jpa.dsas.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    public PatientRepository patientRepository;
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient addNewPatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }

    @Override
    public Patient updatePatient(int id, Patient updatedPatient) {
        return patientRepository.save(updatedPatient);
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
