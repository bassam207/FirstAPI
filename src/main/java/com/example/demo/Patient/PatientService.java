package com.example.demo.Patient;


import com.example.demo.Exceptions.DuplicateResourceException;
import com.example.demo.Exceptions.PatientNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
        if (patientRepository.existsByPhone(dto.phone()))
            throw  new DuplicateResourceException("This phone number existed");
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
                .orElseThrow(() -> new PatientNotFoundException("Patient with ID " + id + " not found!"));
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

    /**
     * Updates the details of an existing patient.
     * @param id the ID of the patient to update.
     * @param dto the new data for the patient.
     * @return the updated patientDto
     * @throws PatientNotFoundException if the patient does not exist.
     */
    public PatientDto updatePatient(Long id , PatientinputDto dto)
    {
        //Retrieve the existing patient
        Patient patient = patientRepository.findById(id).orElseThrow(() ->
                new PatientNotFoundException("patient with "+ id +" id not found"));
        //Update fields
        patient.setAge(dto.age());
        patient.setPhone(dto.phone());
        PatientBio bio = patient.getPatientbio();
        bio.setCompliant(dto.complaint());

        //Saving updated patient
        var saved = patientRepository.save(patient);
        return patientMapper.toDTO(saved);
    }



}
