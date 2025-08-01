package com.example.demo.Patient;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

     List<Patient> findByName(String name) ;
     boolean existsByPhone(Long phone);


}

