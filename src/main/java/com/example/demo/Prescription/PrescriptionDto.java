package com.example.demo.Prescription;

import com.example.demo.Medications.PrescribedMedicationInputDto;

import java.util.List;

public record PrescriptionDto(
        Long appointmentId,
        List<PrescribedMedicationInputDto> medications
) {
}
