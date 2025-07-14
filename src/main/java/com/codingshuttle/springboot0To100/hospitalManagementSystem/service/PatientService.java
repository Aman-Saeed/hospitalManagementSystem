package com.codingshuttle.springboot0To100.hospitalManagementSystem.service;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;



}
