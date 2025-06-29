package com.example.demo.Patient;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    // Constructor Injection
    public PatientService(PatientRepository patientRepository,PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public  PatientDto addPatient(PatientinputDto dto) {
        var patient = patientMapper.toPatient(dto);
        var saved = patientRepository.save(patient);

        return patientMapper.toDTO(saved);
    }


    public List<PatientDto> getAllPatients() {
        List<Patient> patients =  patientRepository.findAll();
        return patients.stream().map(patientMapper::toDTO).collect(Collectors.toList());
    }

    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Patient with ID " + id + " not found!"));
        return  patientMapper.toDTO(patient);
    }

    public  List<PatientDto> getPatientByName(String name)
    {
       List<Patient> patients =  patientRepository.findByName(name);

       return patients.stream().map(patientMapper::toDTO).
               collect(Collectors.toList());
    }

    public void delete(Long id)
    {
        patientRepository.deleteById(id);
    }



}
