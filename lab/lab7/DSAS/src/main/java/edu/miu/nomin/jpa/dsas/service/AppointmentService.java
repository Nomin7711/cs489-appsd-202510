package edu.miu.nomin.jpa.dsas.service;

import edu.miu.nomin.jpa.dsas.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment>   getAllAppointments();
    Appointment        getAppointmentById(int id);
    Appointment        addNewAppointment(Appointment newAppointment);
    Appointment        updateAppointment(int id, Appointment updatedAppointment);
    void               deleteAppointment(int id);
}
