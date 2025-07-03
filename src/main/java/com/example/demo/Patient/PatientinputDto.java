package com.example.demo.Patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record PatientinputDto(
        @NotEmpty
        @NotNull
        String name,
        String gender,
        int age,
        Long phone,
        String complaint,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(min = 8)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "كلمة المرور يجب أن تحتوي على حرف كبير، حرف صغير، رقم، ورمز خاص، وطولها لا يقل عن 8"
        )
                String password

) {
}
