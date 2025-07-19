package com.example.demo.Patient;

import com.example.demo.Appointment.Appointment;
import com.example.demo.Clinic.Clinic;
import com.example.demo.User.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Patients")
public class Patient {

    public PatientBio getPatientbio() {
        return patientbio;
    }

    public void setPatientbio(PatientBio patientbio) {
        this.patientbio = patientbio;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String gender;

    private Long phone;



    @CreationTimestamp
    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;
    @OneToOne(

            mappedBy = "patient",
            cascade = CascadeType.ALL
    )
    private PatientBio patientbio ;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
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
