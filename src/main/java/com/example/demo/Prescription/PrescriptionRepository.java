package com.example.demo.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

    List<Prescription> findByAppointment_Id(Long appointmentId);
}
