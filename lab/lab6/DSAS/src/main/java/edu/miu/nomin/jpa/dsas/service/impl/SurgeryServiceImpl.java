package edu.miu.nomin.jpa.dsas.service.impl;

import edu.miu.nomin.jpa.dsas.model.Surgery;
import edu.miu.nomin.jpa.dsas.repository.SurgeryRepository;
import edu.miu.nomin.jpa.dsas.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    public SurgeryRepository surgeryRepository;
    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery getSurgeryById(int id) {
        return surgeryRepository.findById(id).orElse(null);
    }

    @Override
    public Surgery addNewSurgery(Surgery newSurgery) {
        return surgeryRepository.save(newSurgery);
    }

    @Override
    public Surgery updateSurgery(int id, Surgery updatedSurgery) {
        return surgeryRepository.save(updatedSurgery);
    }

    @Override
    public void deleteSurgery(int id) {
        surgeryRepository.deleteById(id);
    }
}
