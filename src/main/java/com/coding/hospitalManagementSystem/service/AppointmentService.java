package com.coding.hospitalManagementSystem.service;

import com.coding.hospitalManagementSystem.entity.Appointment;
import com.coding.hospitalManagementSystem.repository.AppointmentRepository;
import com.coding.hospitalManagementSystem.repository.DoctorRepository;
import com.coding.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        var patient = patientRepository.findById(patientId).orElseThrow();
        var doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        patientService.deletePatientById(patientId);
        return appointment;
    }
}
