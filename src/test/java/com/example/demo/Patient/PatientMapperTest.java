package com.example.demo.Patient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PatientMapperTest {

    private  PatientMapper patientMapper;




    @Test
    public  void shouldMapPatientDtotoPatient()
    {
        PatientinputDto dto = new PatientinputDto(
                "Hossam","male",30,
                201045L,"Headache");

        Patient patient = patientMapper.toPatient(dto);

        assertEquals(dto.name(),patient.getName());
        assertEquals(dto.gender(),patient.getGender());
        assertEquals(dto.age(),patient.getAge());
        assertEquals(dto.phone(),patient.getPhone());
        assertEquals(dto.complaint(),patient.getPatientbio().getCompliant());


    }

    @Test
    public  void shouldMapPatienttoPatientDto()
    {
        Patient patient = new Patient(
                "Mahmoud",39,"male",2010289965L
        );

        PatientDto dto = patientMapper.toDTO(patient);

        assertEquals(patient.getName(),dto.name());
        assertEquals(patient.getGender(),dto.gender());
        assertEquals(patient.getAge(),dto.age());


    }

    @Test
    void givenNullDto_whenToPatient_thenThrowsNullPointerException() {
        // Arrange & Act
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> patientMapper.toPatient(null)
        );

        // Assert
        assertEquals("dto must not be null", exception.getMessage());
    }


}