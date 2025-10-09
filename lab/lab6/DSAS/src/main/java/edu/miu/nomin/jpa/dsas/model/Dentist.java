package edu.miu.nomin.jpa.dsas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    private String name;
    private String specialty;
    @Getter
    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    public Dentist(String name, String specialty, List<Appointment> appointments) {
        this.name = name;
        this.specialty = specialty;
        this.appointments = appointments;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
}
