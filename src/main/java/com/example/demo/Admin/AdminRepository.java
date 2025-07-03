package com.example.demo.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    boolean existsByPhone(String phoneN);

    Admin findByPhoneN(String phoneN);
}
