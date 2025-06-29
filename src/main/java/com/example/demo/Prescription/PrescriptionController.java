package com.example.demo.Prescription;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // 1️⃣ إنشاء روشتة جديدة
    @PostMapping
    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody PrescriptionDto dto) {
        PrescriptionDto created = prescriptionService.addPrescription(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // 2️⃣ عرض روشتة محددة بالـ ID
    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable Long id) {
        PrescriptionDto dto = prescriptionService.getPrescriptionById(id);
        return ResponseEntity.ok(dto);
    }

    // 3️⃣ عرض كل الروشتات المرتبطة بميعاد معين
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<PrescriptionDto>> getPrescriptionsByAppointmentId(@PathVariable Long appointmentId) {
        List<PrescriptionDto> prescriptions = prescriptionService.getPrescriptionsByAppointmentId(appointmentId);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/test")
    public String test() {
        return "Prescription Controller is working!";
    }

}
