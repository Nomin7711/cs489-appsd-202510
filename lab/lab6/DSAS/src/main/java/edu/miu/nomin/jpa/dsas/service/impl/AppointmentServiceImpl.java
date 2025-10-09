package edu.miu.nomin.jpa.dsas.service.impl;

import edu.miu.nomin.jpa.dsas.model.Appointment;
import edu.miu.nomin.jpa.dsas.repository.AppointmentRepository;
import edu.miu.nomin.jpa.dsas.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    public AppointmentRepository appointmentRepository;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment addNewAppointment(Appointment newAppointment) {
        return appointmentRepository.save(newAppointment);
    }

    public Appointment updateAppointment(int id, Appointment updatedAppointment) {
        return appointmentRepository.save(updatedAppointment);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
