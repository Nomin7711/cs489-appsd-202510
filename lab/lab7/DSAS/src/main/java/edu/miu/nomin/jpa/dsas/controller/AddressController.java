package edu.miu.nomin.jpa.dsas.controller;

import edu.miu.nomin.jpa.dsas.model.Address;
import edu.miu.nomin.jpa.dsas.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1")
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping(value = "/addresses")
    public ResponseEntity<List<Address>> listAddresses() {
        System.out.println("List Addresses called");
        for(Address addr : addressService.getAllAddresses()) {
            System.out.println(addr);
        }
        return ResponseEntity.ok(addressService.getAllAddresses());
    }
}
