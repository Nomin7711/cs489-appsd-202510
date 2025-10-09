package edu.miu.nomin.jpa.dsas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer patientId;
    private String name;
    private String email;
    private String phone;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    public Patient(String name, String email, String phone, Address address, List<Appointment> appointments) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.appointments = appointments;
    }
}
