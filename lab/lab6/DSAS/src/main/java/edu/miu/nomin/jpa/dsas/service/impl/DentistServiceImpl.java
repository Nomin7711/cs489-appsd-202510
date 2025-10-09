package edu.miu.nomin.jpa.dsas.service.impl;

import edu.miu.nomin.jpa.dsas.model.Dentist;
import edu.miu.nomin.jpa.dsas.repository.DentistRepository;
import edu.miu.nomin.jpa.dsas.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    public DentistRepository dentistRepository;
    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public Dentist getDentistById(int id) {
        return dentistRepository.findById(id).orElse(null);
    }

    public Dentist addNewDentist(Dentist newDentist) {
        return dentistRepository.save(newDentist);
    }

    public Dentist updateDentist(int id, Dentist updatedDentist) {
        return dentistRepository.save(updatedDentist);
    }

    public void deleteDentist(int id) {
        dentistRepository.deleteById(id);
    }
}
