package edu.miu.nomin.jpa.dsas.service;

import edu.miu.nomin.jpa.dsas.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address      getAddressById(int id);
    Address      addNewAddress(Address newAddress);
    Address      updateAddress(int id, Address updatedAddress);
    void         deleteAddress(int id);
}
