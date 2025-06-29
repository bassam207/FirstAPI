package com.example.demo.Prescription;

public record PrescribedMedicationInputDto(
       String name,
        String dosage,
        String frequency,
        Integer durationDays,
        String route,
        String instructions
) {
}
