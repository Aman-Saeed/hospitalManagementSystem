package com.coding.hospitalManagementSystem;


import com.coding.hospitalManagementSystem.entity.Appointment;
import com.coding.hospitalManagementSystem.entity.Insurance;
import com.coding.hospitalManagementSystem.service.AppointmentService;
import com.coding.hospitalManagementSystem.service.InsuranceService;
import com.coding.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testAssignInsuranceToPatient() {
        // Call the service method to assign insurance to a patient
        Insurance insurance = Insurance.builder()
                .policyNumber("POL123456")
                .provider("HealthCare Inc.")
                .validUntil(LocalDate.of(2028, 12, 31))
                .build();
        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance,1L);

        System.out.println("Insurance assigned to patient: " + updatedInsurance);

       // patientService.deletePatientById(1L);

        var patient = insuranceService.removeInsuranceOfPatient(1L);
        System.out.println("Insurance removed from patient: " + patient);


    }

    @Test
    public void testCreateAppointment(){

       Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2024, 7, 15, 10, 30))
                .reason("Regular Checkup")
                .build();

      var updatedAppointment = appointmentService.createNewAppointment(appointment, 1L, 1L);

        System.out.println("Appointment created: " + updatedAppointment);
    }



}
