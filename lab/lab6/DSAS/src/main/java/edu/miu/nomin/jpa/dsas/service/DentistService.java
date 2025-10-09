package edu.miu.nomin.jpa.dsas.service;

import edu.miu.nomin.jpa.dsas.model.Dentist;

import java.util.List;

public interface DentistService {
    List<Dentist>   getAllDentists();
    Dentist         getDentistById(int id);
    Dentist         addNewDentist(Dentist newDentist);
    Dentist         updateDentist(int id, Dentist updatedDentist);
    void            deleteDentist(int id);
}
