package com.example.demo.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentDTO(LocalDate date,
                             LocalTime time,
                             String doctorName,
                             String patientName) {
}
