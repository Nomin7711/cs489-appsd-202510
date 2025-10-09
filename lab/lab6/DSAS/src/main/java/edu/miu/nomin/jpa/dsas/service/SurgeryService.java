package edu.miu.nomin.jpa.dsas.service;

import edu.miu.nomin.jpa.dsas.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery>   getAllSurgeries();
    Surgery        getSurgeryById(int id);
    Surgery        addNewSurgery(Surgery newSurgery);
    Surgery        updateSurgery(int id, Surgery updatedSurgery);
    void           deleteSurgery(int id);
}
