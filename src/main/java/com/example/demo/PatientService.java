package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PatientService {

    private final PatientRepository patientRepository;

    // Constructor Injection
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Patient with ID " + id + " not found!"));
    }

    public  List<Patient> getPatientByName(String name)
    {
       return  patientRepository.findByName(name);
    }

    public void delete(Long id)
    {
        patientRepository.deleteById(id);
    }



}
