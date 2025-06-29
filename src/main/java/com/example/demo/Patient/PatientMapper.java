package com.example.demo.Patient;

import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public  PatientDto toDTO(Patient patient)
    {
        return  new PatientDto(patient.getName(),patient.getGender(),patient.getAge());
    }

    public Patient toPatient(PatientinputDto dto)
    {
        if (dto == null)
        {
            throw new NullPointerException("dto must not be null");
        }

        Patient patient = new Patient();
        patient.setName(dto.name());
        patient.setAge(dto.age());
        patient.setGender(dto.gender());
        patient.setPhone(dto.phone());


        PatientBio bio = new PatientBio();
        bio.setCompliant(dto.complaint());
        bio.setPatient(patient);
        patient.setPatientbio(bio);

        return patient;
    }


}
