package com.example.demo.Prescription;

import com.example.demo.Appointment.Appointment;

import java.util.List;

public class PrescriptionMapper {

    // 🔁 تحويل من DTO إلى Entity
    public static Prescription toEntity(
            PrescriptionDto dto,
            Appointment appointment,
            List<PrescribedMedication> prescribedList
    ) {
        Prescription prescription = new Prescription();
        prescription.setAppointment(appointment);

        for (PrescribedMedication pm : prescribedList) {
            pm.setPrescription(prescription);
        }

        prescription.setPrescribedMedications(prescribedList);
        return prescription;
    }

    // 🔁 تحويل من Entity إلى DTO للعرض
    public static PrescriptionDto toDto(Prescription p) {
        List<PrescribedMedicationInputDto> meds = p.getPrescribedMedications()
                .stream()
                .map(m -> new PrescribedMedicationInputDto(

                        m.getMedication().getName(),
                        m.getDosage(),
                        m.getFrequency(),
                        m.getDurationDays(),
                        m.getRoute(),
                        m.getInstructions()
                ))
                .toList();

        return new PrescriptionDto(

                p.getAppointment().getId(),
                meds
        );
    }
}

