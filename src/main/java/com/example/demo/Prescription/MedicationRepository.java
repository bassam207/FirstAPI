package com.example.demo.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
    Optional<Medication> findByName(String name);
    List<Medication> findByNameContainingIgnoreCase(String name);

}
