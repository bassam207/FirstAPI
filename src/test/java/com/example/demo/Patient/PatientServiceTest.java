package com.example.demo.Patient;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public  void should_successfully_save_one_patient()
    {

        // Given
        PatientinputDto dto = new PatientinputDto(
                "Ali",
                "male",
                20,
                201187965432L,
                "Diarrhea"
        );

        Patient patient = new Patient(
                "Ali",
                20,
                "male",
                201187965432L
        );

        //Mock calls
        when(patientMapper.toPatient(dto)).thenReturn(patient);

        when(patientRepository.save(patient)).thenReturn(patient);

        when(patientMapper.toDTO(patient)).thenReturn(

                new PatientDto(
                        "Ali",
                        "male",
                        20

                )
        );

        //When

        PatientDto patientDto = patientService.addPatient(dto);



        //Then

        assertEquals(patientDto.name(),dto.name());
        assertEquals(patientDto.age(),dto.age());
        assertEquals(patientDto.gender(),dto.gender());

        verify(patientMapper,times(1)).toPatient(dto);
        verify(patientRepository,times(1)).save(patient);
        verify(patientMapper,times(1)).toDTO(patient);

    }

    @Test
    public void should_successfully_find_all_patients()
    {
        // Given

        List<Patient> patients = new ArrayList<>();
        patients.add(
                new Patient(
                        "Ali",
                        20,
                        "male",
                        201187965432L
                )
        );

        //Mock calls

        when(patientRepository.findAll()).thenReturn(patients);

        when(patientMapper.toDTO(any(Patient.class))).thenReturn(new PatientDto(
                "Ali",
                "male",
                20

        ));

        //When

        List<PatientDto> patientDtos = patientService.getAllPatients();

        //Then

        assertEquals(patientDtos.size(),patients.size());
        verify(patientRepository,times(1)).findAll();
    }

    @Test
    public void should_return_one_patient_of_one_id()
    {
        //Given
        Long id = 1L;
        Patient patient = new Patient(
                "Ali",
                20,
                "male",
                201187965432L
        );
        //Mock calls

        when(patientRepository.findById(id)).thenReturn(Optional.of(patient));

        when(patientMapper.toDTO(patient)).thenReturn(new PatientDto(
                "Ali",
                "male",
                20

                ));

        //When
        PatientDto dto = patientService.getPatientById(id);

        //Then
        assertEquals(dto.name(),patient.getName());
        assertEquals(dto.gender(),patient.getGender());
        assertEquals(dto.age(),patient.getAge());
        verify(patientRepository,times(1)).findById(id);

    }

    @Test
    public void should_return_patients_of_name()
    {
        //Given

        String name = "Ali";
        List<Patient> patients = new ArrayList<>();
        patients.add(
                new Patient(
                        "Ali",
                        20,
                        "male",
                        201187965432L
        ));

        //Mock calls
        when(patientRepository.findByName(name)).thenReturn(patients);
        when(patientMapper.toDTO(any(Patient.class))).thenReturn(new PatientDto(
                "Ali",
                "male",
                20

        ));
        //When
        List<PatientDto> dtos = patientService.getPatientByName(name);
        //Then
        assertEquals(dtos.size(),patients.size());
        verify(patientRepository,times(1)).findByName(name);
    }
}