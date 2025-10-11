package edu.miu.nomin.jpa.dsas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private String name;
    private String email;
    private String phone;
    private AddressDTO address;
}
