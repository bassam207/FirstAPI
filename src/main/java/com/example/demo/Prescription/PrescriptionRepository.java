package com.example.demo.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface PrescriptionRepository extends MongoRepository<Prescription, Long> {

    List<Prescription> findByAppointment_Id(Long appointmentId);
}
