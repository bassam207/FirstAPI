package com.example.demo;
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
