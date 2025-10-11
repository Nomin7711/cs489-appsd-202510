package edu.miu.nomin.jpa.dsas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @OneToMany(mappedBy = "surgery", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
