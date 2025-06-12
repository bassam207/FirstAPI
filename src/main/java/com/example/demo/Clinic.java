package com.example.demo;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<Patient> patients;
    public Clinic() {
    }

    public Clinic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
