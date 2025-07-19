package com.example.demo.Admin;

import com.example.demo.User.User;
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user ;
    public Admin(String name , String phoneN )
    {
        this.name = name;
        this.phoneN = phoneN;

    }
}

