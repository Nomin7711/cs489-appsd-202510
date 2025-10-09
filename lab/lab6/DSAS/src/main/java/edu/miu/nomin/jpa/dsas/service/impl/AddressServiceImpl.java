package edu.miu.nomin.jpa.dsas.service.impl;

import edu.miu.nomin.jpa.dsas.model.Address;
import edu.miu.nomin.jpa.dsas.repository.AddressRepository;
import edu.miu.nomin.jpa.dsas.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    public Address updateAddress(int id, Address updatedAddress) {
        return addressRepository.save(updatedAddress);
    }

    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }

}
