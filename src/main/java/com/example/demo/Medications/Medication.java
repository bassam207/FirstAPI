package com.example.demo.Medications;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String form;
    private String strength;

    @OneToMany (mappedBy = "medication", cascade = CascadeType.ALL)
    private List<PrescribedMedication> prescribedMedications = new ArrayList<>();

    public Medication() {
    }

    public Medication(String name, String form, String strength) {
        this.name = name;

        this.form = form;
        this.strength = strength;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
