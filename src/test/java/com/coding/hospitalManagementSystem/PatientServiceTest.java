package com.coding.hospitalManagementSystem;

import com.coding.hospitalManagementSystem.entity.Patient;
import com.coding.hospitalManagementSystem.repository.PatientRepository;
import com.coding.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;;

    @Test
    public void testPatientDelete(){
        patientService.deletePatientById(1L);
    }
    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for(var p: patientList) {
//            System.out.println(p);
//        }

//        int rowsAffected = patientRepository.updatePatientNameWithId("Anuj Sharma", 1L);
//
//        System.out.println(rowsAffected);

        List<Patient> patientList = patientRepository.getAllPatientWithAppointment();

        for(var p: patientList) {
            System.out.println(p);
        }

    }
}
