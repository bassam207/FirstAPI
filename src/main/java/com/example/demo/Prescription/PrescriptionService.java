package com.example.demo.Prescription;
import java.util.List;

import com.example.demo.Appointment.Appointment;
import com.example.demo.Appointment.AppointmentRepository;
import com.example.demo.Medications.Medication;
import com.example.demo.Medications.MedicationRepository;
import com.example.demo.Medications.PrescribedMedication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final AppointmentRepository appointmentRepository;
    private final MedicationRepository medicationRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               AppointmentRepository appointmentRepository,
                               MedicationRepository medicationRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.appointmentRepository = appointmentRepository;
        this.medicationRepository = medicationRepository;
    }

    public PrescriptionDto addPrescription(PrescriptionDto dto) {
        // 1. هات الموعد
        Appointment appointment = appointmentRepository.findById(dto.appointmentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));


        List<PrescribedMedication> meds = dto.medications().stream().map(medDto -> {
            Medication med = medicationRepository.findByName(medDto.name())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));

            PrescribedMedication pm = new PrescribedMedication();
            pm.setMedication(med);
            pm.setDosage(medDto.dosage());
            pm.setFrequency(medDto.frequency());
            pm.setDurationDays(medDto.durationDays());
            pm.setRoute(medDto.route());
            pm.setInstructions(medDto.instructions());
            return pm;
        }).toList();

        // 3. اربطهم بالروشتة
        Prescription prescription = PrescriptionMapper.toEntity(dto, appointment, meds);

        // 4. احفظها
        Prescription saved = prescriptionRepository.save(prescription);

        return PrescriptionMapper.toDto(saved);
    }

    public List<PrescriptionDto> getPrescriptionsByAppointmentId(Long appointmentId) {
        return prescriptionRepository.findByAppointment_Id(appointmentId).stream()
                .map(PrescriptionMapper::toDto)
                .toList();
    }

    public PrescriptionDto getPrescriptionById(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prescription not found"));
        return PrescriptionMapper.toDto(prescription);
    }
}
