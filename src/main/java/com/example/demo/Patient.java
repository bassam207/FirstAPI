package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String gender;

    private Long phone;
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;
    @OneToOne(

            mappedBy = "patient",
            cascade = CascadeType.ALL
    )
    private PatientBio patientbio ;


    // Constructors
    public Patient() {
    }

    public Patient(String name, int age, String gender, Long phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }


}
