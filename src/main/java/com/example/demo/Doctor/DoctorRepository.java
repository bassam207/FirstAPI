package com.example.demo.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends  JpaRepository<Doctor,Long> {

    boolean existesByPhone(long phone);
}
