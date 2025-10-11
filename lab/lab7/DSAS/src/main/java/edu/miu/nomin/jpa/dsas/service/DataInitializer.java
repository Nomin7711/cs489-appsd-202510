package edu.miu.nomin.jpa.dsas.service;
import edu.miu.nomin.jpa.dsas.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AddressService addressService;
    private final PatientService patientService;
    private final DentistService dentistService;
    private final SurgeryService surgeryService;
    private final AppointmentService appointmentService;

    public DataInitializer(AddressService addressService,
                           PatientService patientService,
                           DentistService dentistService,
                           SurgeryService surgeryService,
                           AppointmentService appointmentService) {
        this.addressService = addressService;
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        // 1️⃣ Create and save Addresses
//        Address addr1 = addressService.addNewAddress(new Address("123 Main St", "Fairfield", "IA", "52557"));
//        Address addr2 = addressService.addNewAddress(new Address("45 Oak St", "Fairfield", "IA", "52557"));
//        Address addr3 = addressService.addNewAddress(new Address("78 River Rd", "Ottumwa", "IA", "52501"));
//        Address addr4 = addressService.addNewAddress(new Address("99 Elm St", "Ottumwa", "IA", "52501"));
//
//        // 2️⃣ Create and save Dentists
//        Dentist d1 = dentistService.addNewDentist(new Dentist("Tony Smith", "Root Canal Specialist", new ArrayList<>()));
//        Dentist d2 = dentistService.addNewDentist(new Dentist("Helen Pearson", "Oral Surgeon", new ArrayList<>()));
//        Dentist d3 = dentistService.addNewDentist(new Dentist("Robin Plevin", "Implant Specialist", new ArrayList<>()));
//
//        // 3️⃣ Create and save Patients
//        Patient p1 = patientService.addNewPatient(new Patient("Gillian White", "gillian@example.com", "555-1234", addr1, new ArrayList<>()));
//        Patient p2 = patientService.addNewPatient(new Patient("Jill Bell", "jill@example.com", "555-2345", addr2, new ArrayList<>()));
//        Patient p3 = patientService.addNewPatient(new Patient("Ian MacKay", "ian@example.com", "555-3456", addr3, new ArrayList<>()));
//        Patient p4 = patientService.addNewPatient(new Patient("John Walker", "john@example.com", "555-4567", addr4, new ArrayList<>()));
//
//        // 4️⃣ Create and save Surgeries
//        Surgery s1 = surgeryService.addNewSurgery(new Surgery("Tooth Extraction", "12-Sep-13", "Helen Pearson", addr1, new ArrayList<>()));
//        Surgery s2 = surgeryService.addNewSurgery(new Surgery("Implant", "15-Sep-13", "Robin Plevin", addr2, new ArrayList<>()));
//        Surgery s3 = surgeryService.addNewSurgery(new Surgery("Root Canal", "12-Sep-13", "Tony Smith", addr3, new ArrayList<>()));
//
//        // 5️⃣ Create and save Appointments
//        appointmentService.addNewAppointment(new Appointment("12-Sep-13", "10:00", "Routine check-up", s3, p1, d1));
//        appointmentService.addNewAppointment(new Appointment("12-Sep-13", "12:00", "Filling", s3, p2, d1));
//        appointmentService.addNewAppointment(new Appointment("12-Sep-13", "10:00", "Extraction", s1, p3, d2));
//        appointmentService.addNewAppointment(new Appointment("14-Sep-13", "14:00", "Follow-up", s1, p3, d2));
//        appointmentService.addNewAppointment(new Appointment("14-Sep-13", "16:30", "Cleaning", s3, p2, d3));
//        appointmentService.addNewAppointment(new Appointment("15-Sep-13", "18:00", "Implant Consultation", s2, p4, d3));
    }
}
