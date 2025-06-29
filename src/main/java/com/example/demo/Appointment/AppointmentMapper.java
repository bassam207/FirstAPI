package com.example.demo.Appointment;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Patient.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentMapper {

    public static Appointment toAppointment(
            AppointmentinputDTO dto,
            Doctor doctor,
            Patient patient
    ) {
        Appointment a = new Appointment();
        a.setDate(LocalDate.now());
        a.setTime(LocalTime.now());
        a.setDoctor(doctor);
        a.setPatient(patient);
        return a;
    }

    public static AppointmentDTO toDto(Appointment appointment) {
        return new AppointmentDTO(

                appointment.getDate(),
                appointment.getTime(),
                appointment.getDoctor().getName(),
                appointment.getPatient().getName()
        );
    }
}
