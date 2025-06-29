package com.example.demo.Prescription;

import java.util.List;

public record PrescriptionDto(
        Long appointmentId,
        List<PrescribedMedicationInputDto> medications
) {
}
