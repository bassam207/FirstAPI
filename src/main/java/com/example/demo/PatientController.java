package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class PatientController {

    private final PatientService patientService;

    // Constructor Injection
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable
                                          Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/search/{name}")
    public  List<Patient> getPatientByName(@RequestParam  String name)
    {
        return patientService.getPatientByName(name);
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Long id)
    {
        patientService.delete(id);
    }
}

