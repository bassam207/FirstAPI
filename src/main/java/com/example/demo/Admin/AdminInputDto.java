
package com.example.demo.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AdminInputDto(

        @NotNull(message = "Username cannot be null")
        @NotBlank
         String name,
                @NotBlank
                @Pattern(regexp = "\\d{01}")
            String phoneN,

@Size(min = 8)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
@NotBlank
@Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "كلمة المرور يجب أن تحتوي على حرف كبير، حرف صغير، رقم، ورمز خاص، وطولها لا يقل عن 8"
)
 String password


        ) {


                }