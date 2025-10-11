package edu.miu.nomin.jpa.dsas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
}
