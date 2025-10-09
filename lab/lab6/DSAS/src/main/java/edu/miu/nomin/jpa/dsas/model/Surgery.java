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
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer surgeryId;
    private String surgeryType;
    private String date;
    private String surgeonName;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;
    @OneToMany(mappedBy = "surgery", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Surgery(String surgeryType, String date, String surgeonName, Address address, List<Appointment> appointments) {
        this.surgeryType = surgeryType;
        this.date = date;
        this.surgeonName = surgeonName;
        this.address = address;
        this.appointments = appointments;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
}
