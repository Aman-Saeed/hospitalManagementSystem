package com.coding.hospitalManagementSystem.service;


import com.coding.hospitalManagementSystem.entity.Insurance;
import com.coding.hospitalManagementSystem.entity.Patient;
import com.coding.hospitalManagementSystem.repository.InsuranceRepository;
import com.coding.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);

        insurance.setPatient(patient); //Optional

        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);

        insurance.setPatient(patient); //Optional

        return insurance;
    }
    @Transactional
    public Patient removeInsuranceOfPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);

        return patient;
    }

}
