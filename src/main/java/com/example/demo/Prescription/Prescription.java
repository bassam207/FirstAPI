package com.example.demo.Prescription;

import com.example.demo.Appointment.Appointment;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Entity
@Document(collation = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<PrescribedMedication> prescribedMedications;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public Prescription() {
    }

    public Prescription(Appointment appointment, List<PrescribedMedication> prescribedMedications) {
        this.appointment = appointment;
        prescribedMedications = prescribedMedications;
    }

    public List<PrescribedMedication> getPrescribedMedications() {
        return prescribedMedications;
    }

    public void setPrescribedMedications(List<PrescribedMedication> prescribedMedications) {
        this.prescribedMedications = prescribedMedications;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
