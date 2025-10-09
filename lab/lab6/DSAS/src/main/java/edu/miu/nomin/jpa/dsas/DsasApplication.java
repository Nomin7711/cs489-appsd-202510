package edu.miu.nomin.jpa.dsas;

import edu.miu.nomin.jpa.dsas.model.*;
import edu.miu.nomin.jpa.dsas.service.AddressService;
import edu.miu.nomin.jpa.dsas.service.AppointmentService;
import edu.miu.nomin.jpa.dsas.service.DentistService;
import edu.miu.nomin.jpa.dsas.service.PatientService;
import edu.miu.nomin.jpa.dsas.service.impl.SurgeryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DsasApplication implements CommandLineRunner {
    @Autowired
    private DentistService dentistServiceImpl;
    @Autowired
    private AddressService addressServiceImpl;
    @Autowired
    private PatientService patientServiceImpl;
    @Autowired
    private AppointmentService appointmentServiceImpl;
    @Autowired
    private SurgeryServiceImpl surgeryServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(DsasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // 1️⃣ Create and save Addresses for Patients
        Address pAddr1 = new Address("123 Main St", "Fairfield", "IA", "52557");
        Address pAddr2 = new Address("45 Oak St", "Fairfield", "IA", "52557");
        Address pAddr3 = new Address("78 River Rd", "Ottumwa", "IA", "52501");
        Address pAddr4 = new Address("99 Elm St", "Ottumwa", "IA", "52501"); // unique for last patient

        pAddr1 = addressServiceImpl.addNewAddress(pAddr1);
        pAddr2 = addressServiceImpl.addNewAddress(pAddr2);
        pAddr3 = addressServiceImpl.addNewAddress(pAddr3);
        pAddr4 = addressServiceImpl.addNewAddress(pAddr4);

        // 2️⃣ Create and save Patients (assign unique addresses)
        Patient p100 = new Patient("Gillian White", "gillian@example.com", "555-1234", pAddr1, new ArrayList<>());
        Patient p105 = new Patient("Jill Bell", "jill@example.com", "555-2345", pAddr2, new ArrayList<>());
        Patient p108 = new Patient("Ian MacKay", "ian@example.com", "555-3456", pAddr3, new ArrayList<>());
        Patient p110 = new Patient("John Walker", "john@example.com", "555-4567", pAddr4, new ArrayList<>());

        p100 = patientServiceImpl.addNewPatient(p100);
        p105 = patientServiceImpl.addNewPatient(p105);
        p108 = patientServiceImpl.addNewPatient(p108);
        p110 = patientServiceImpl.addNewPatient(p110);

        // 3️⃣ Create and save Addresses for Surgeries
        Address sAddr1 = new Address("123 Main St", "Fairfield", "IA", "52557");
        Address sAddr2 = new Address("45 Oak St", "Fairfield", "IA", "52557");
        Address sAddr3 = new Address("78 River Rd", "Ottumwa", "IA", "52501");

        sAddr1 = addressServiceImpl.addNewAddress(sAddr1);
        sAddr2 = addressServiceImpl.addNewAddress(sAddr2);
        sAddr3 = addressServiceImpl.addNewAddress(sAddr3);

        // 4️⃣ Create and save Surgeries (assign unique addresses)
        Surgery s10 = new Surgery("Tooth Extraction", "12-Sep-13", "Helen Pearson", sAddr1, new ArrayList<>());
        Surgery s13 = new Surgery("Implant", "15-Sep-13", "Robin Plevin", sAddr2, new ArrayList<>());
        Surgery s15 = new Surgery("Root Canal", "12-Sep-13", "Tony Smith", sAddr3, new ArrayList<>());

        s10 = surgeryServiceImpl.addNewSurgery(s10);
        s13 = surgeryServiceImpl.addNewSurgery(s13);
        s15 = surgeryServiceImpl.addNewSurgery(s15);

        // 5️⃣ Create and save Dentists
        Dentist d1 = new Dentist("Tony Smith", "Root Canal Specialist", new ArrayList<>());
        Dentist d2 = new Dentist("Helen Pearson", "Oral Surgeon", new ArrayList<>());
        Dentist d3 = new Dentist("Robin Plevin", "Implant Specialist", new ArrayList<>());

        d1 = dentistServiceImpl.addNewDentist(d1);
        d2 = dentistServiceImpl.addNewDentist(d2);
        d3 = dentistServiceImpl.addNewDentist(d3);

        // 6️⃣ Create and save Appointments
        Appointment a1 = new Appointment("12-Sep-13", "10:00", "Routine check-up", s15, p100, d1);
        Appointment a2 = new Appointment("12-Sep-13", "12:00", "Filling", s15, p105, d1);
        Appointment a3 = new Appointment("12-Sep-13", "10:00", "Extraction", s10, p108, d2);
        Appointment a4 = new Appointment("14-Sep-13", "14:00", "Follow-up", s10, p108, d2);
        Appointment a5 = new Appointment("14-Sep-13", "16:30", "Cleaning", s15, p105, d3);
        Appointment a6 = new Appointment("15-Sep-13", "18:00", "Implant Consultation", s13, p110, d3);

        appointmentServiceImpl.addNewAppointment(a1);
        appointmentServiceImpl.addNewAppointment(a2);
        appointmentServiceImpl.addNewAppointment(a3);
        appointmentServiceImpl.addNewAppointment(a4);
        appointmentServiceImpl.addNewAppointment(a5);
        appointmentServiceImpl.addNewAppointment(a6);

        System.out.println("Database seeded successfully!");
    }

}
