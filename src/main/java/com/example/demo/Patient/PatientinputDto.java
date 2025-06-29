package com.example.demo.Patient;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PatientinputDto(
        @NotEmpty
        @NotNull
        String name,
        String gender,
        int age,
        Long phone,
        String complaint

) {
}
