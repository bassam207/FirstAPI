package com.example.demo.Patient;
import jakarta.persistence.*;
@Entity

public class PatientBio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compliant;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private  Patient patient;

    public PatientBio() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientBio(String compliant) {
        this.compliant = compliant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompliant() {
        return compliant;
    }

    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }
}
