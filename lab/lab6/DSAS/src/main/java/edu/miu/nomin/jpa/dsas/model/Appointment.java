package edu.miu.nomin.jpa.dsas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private String date;
    private String time;
    private String description;
    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    public Appointment(String date, String time, String description, Surgery surgery, Patient patient, Dentist dentist) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.surgery = surgery;
        this.patient = patient;
        this.dentist = dentist;
    }
}
