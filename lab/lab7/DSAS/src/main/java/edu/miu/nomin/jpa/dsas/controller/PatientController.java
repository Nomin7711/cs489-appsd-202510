package edu.miu.nomin.jpa.dsas.controller;

import edu.miu.nomin.jpa.dsas.dto.PatientDTO;
import edu.miu.nomin.jpa.dsas.dto.PatientRequestDTO;
import edu.miu.nomin.jpa.dsas.exception.InvalidPatientDataException;
import edu.miu.nomin.jpa.dsas.exception.PatientNotFoundException;
import edu.miu.nomin.jpa.dsas.mapper.PatientMapper;
import edu.miu.nomin.jpa.dsas.model.Patient;
import edu.miu.nomin.jpa.dsas.service.PatientService;
import edu.miu.nomin.jpa.dsas.service.impl.PatientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//1. HTTP GET request: http://localhost:8080/adsweb/api/v1/patients -
// Displays the list of all Patients, including their primaryAddresses,
// sorted in ascending order by their lastName, in JSON format.
//
//        2. HTTP GET request: http://localhost:8080/adsweb/api/v1/patients/1 -
//        Displays the data for Patient whose PatientId is 1 including the primaryAddress,
//        in JSON format. Also, make sure to implement appropriate exception handling,
//        for where patientId is invalid and not found.
//
//        3. HTTP POST request: http://localhost:8080/adsweb/api/v1/patients -
//        Register a new Patient into the system. Note: You supply the correct/appropriate Patient data in JSON format
//
//        4. HTTP PUT request: http://localhost:8080/adsweb/api/v1/patient/1 -
//        Retrieves and updates Patient data for the patient whose patientId is 1
//        (or any other valid patientId). Also, make sure to implement appropriate exception handling,
//        for where patientId is invalid and not found.
//
//        5. HTTP DELETE request: http://localhost:8080/adsweb/api/v1/patient/1 -
//        Deletes the Patient data for the patient whose patientId is 1 (or any other valid patientId).
//
//        6. http://localhost:8080/adsweb/api/v1/patient/search/{searchString} -
//        Queries all the Patient data for the patient(s) whose data matches the input searchString.
//

@RestController
@RequestMapping(value = "/adsweb/api/v1")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/patients")
    public ResponseEntity<List<PatientDTO>> listPatientsSortedByName() {
        List<PatientDTO> patients = patientService.findAllPatientsSortedByName().stream().map(PatientMapper::toDTO).toList();
        return ResponseEntity.ok(patients);
    }

    @GetMapping(value = "/patients/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Integer id) throws PatientNotFoundException {
        if (id == null || id <= 0) {
            throw new PatientNotFoundException("Invalid patient ID: " + id);
        }
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(PatientMapper.toDTO(patient));
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientRequestDTO> createPatient(@RequestBody PatientRequestDTO patientDTO) {
        if (patientDTO.getName() == null || patientDTO.getName().isBlank() ||
                patientDTO.getEmail() == null || patientDTO.getEmail().isBlank() ||
                patientDTO.getPhone() == null || patientDTO.getPhone().isBlank() ||
                patientDTO.getAddress() == null) {
            throw new InvalidPatientDataException("Missing required patient fields");
        }

        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhone(patientDTO.getPhone());
        patient.setAddress(patientDTO.getAddress());

        patientService.addNewPatient(patient);

        return ResponseEntity.status(201).body(patientDTO);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Integer id, @RequestBody PatientRequestDTO patientDTO) {

        if (id == null || id <= 0) {
            throw new InvalidPatientDataException("Invalid patient ID: " + id);
        }

        Patient existingPatient = patientService.getPatientById(id);
        if (existingPatient == null) {
            throw new PatientNotFoundException("Invalid patient ID: " + id);
        }

        if (patientDTO.getName() == null || patientDTO.getName().isBlank() ||
                patientDTO.getEmail() == null || patientDTO.getEmail().isBlank() ||
                patientDTO.getPhone() == null || patientDTO.getPhone().isBlank() ||
                patientDTO.getAddress() == null) {
            throw new InvalidPatientDataException("Missing required patient fields");
        }

        existingPatient.setName(patientDTO.getName());
        existingPatient.setEmail(patientDTO.getEmail());
        existingPatient.setPhone(patientDTO.getPhone());
        existingPatient.setAddress(patientDTO.getAddress());

        patientService.updatePatient(id, existingPatient);
        return ResponseEntity.ok(PatientMapper.toDTO(existingPatient));
    }
    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            throw new InvalidPatientDataException("Invalid patient ID: " + id);
        }
        Patient existingPatient = patientService.getPatientById(id);
        if (existingPatient == null) {
            throw new PatientNotFoundException("Patient with ID " + id + " not found");
        }
        patientService.deletePatient(id);
        return ResponseEntity.ok(Map.of("message", "Patient with ID " + id + " deleted successfully"));
    }
    @GetMapping("/patient/search/{searchString}")
    public ResponseEntity<List<PatientDTO>> searchPatients(@PathVariable String searchString) {
        List<Patient> patients = patientService.searchPatients(searchString);
        for (Patient p : patients) {
            System.out.println(p);
        }
        List<PatientDTO> patientDTOs = patients.stream()
                .map(PatientMapper::toDTO)
                .toList();

        return ResponseEntity.ok(patientDTOs);
    }




}
