package com.example.demo.Admin;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admins")
public class AdminController {

    private  AdminService adminService;

    public  AdminController(AdminService adminService)
    {
        this.adminService = adminService;
    }

    // Create Admin
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminInputDto adminInputDto) {
        AdminDto savedAdmin = adminService.createAdmin(adminInputDto);
        return ResponseEntity.ok(savedAdmin);
    }

    // Get all admins
    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    // Get admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    // Delete admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
