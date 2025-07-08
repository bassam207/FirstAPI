package com.example.demo.Medications;

public record PrescribedMedicationInputDto(
       String name,
        String dosage,
        String frequency,
        Integer durationDays,
        String route,
        String instructions
) {
}
