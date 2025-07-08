package com.example.demo.Admin;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String phoneN;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    private String role = "ADMIN";

    public Admin(String name , String phoneN , String password)
    {
        this.name = name;
        this.phoneN = phoneN;
        this.password = password;
    }
}

