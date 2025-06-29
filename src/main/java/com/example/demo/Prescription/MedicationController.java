package com.example.demo.Medication;

import com.example.demo.Prescription.Medication;
import com.example.demo.Prescription.MedicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin

@RestController
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    //@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /*public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        List<Medication> medications = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip header
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    String name = fields[0].trim();
                    String form = fields[1].trim();
                    String strength = fields[2].trim();
                    Medication medication = new Medication();
                    medication.setName(name);
                    medication.setForm(form);
                    medication.setStrength(strength);
                    medications.add(medication);
                }
            }
            medicationRepository.saveAll(medications);
            return ResponseEntity.ok("Successfully uploaded " + medications.size() + " medications.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file: " + e.getMessage());
        }
    }*/

    @GetMapping("/search")
    public ResponseEntity<List<Medication>> search(@RequestParam String query) {
        List<Medication> medications = medicationRepository.findByNameContainingIgnoreCase(query);
        return ResponseEntity.ok(medications);
    }

}
