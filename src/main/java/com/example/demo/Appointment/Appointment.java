package com.example.demo.Appointment;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Patient.Patient;
import com.example.demo.Prescription.Prescription;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime time ;

    private LocalTime endtime;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor ;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;





    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions ;
    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

}
