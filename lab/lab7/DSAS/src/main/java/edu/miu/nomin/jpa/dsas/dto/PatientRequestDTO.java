package edu.miu.nomin.jpa.dsas.dto;

import edu.miu.nomin.jpa.dsas.model.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Phone cannot be empty")
    private String phone;
    @NotBlank(message = "Address cannot be empty")
    private Address address; // include address object
}
