package com.example.demo.User;

import com.example.demo.Admin.Admin;
import com.example.demo.Doctor.Doctor;
import com.example.demo.Patient.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private boolean enabled = true;

    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Patient patientProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Doctor doctorProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Admin adminProfile;
}
