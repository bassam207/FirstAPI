package com.example.demo.Admin;

import com.example.demo.Exceptions.AdminNotFoundException;
import com.example.demo.Exceptions.DuplicateResourceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService
{

    private  AdminRepository adminRepository;
    private  AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository , AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public AdminDto createAdmin(AdminInputDto inputDto) {
        if (adminRepository.existsByPhone(inputDto.phoneN()))
            throw new
                    DuplicateResourceException("This phone number is existed");
        Admin admin = new Admin();
        admin.setName(inputDto.name());
        admin.setPhoneN(inputDto.phoneN());
        admin.setPassword(inputDto.password());

        Admin saved = adminRepository.save(admin);


        return new AdminDto(
                saved.getId(),
                saved.getName(),
                saved.getPhoneN()
        );
    }

    public List<AdminDto> getAllAdmins() {
        List<Admin> admins =  adminRepository.findAll();
        return admins.stream().map(adminMapper::toDto).collect(Collectors.toList());
    }

    public AdminDto getAdminById(Long id) {
        Admin ad =  adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + id));
        return adminMapper.toDto(ad);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public AdminDto updateAdmin(Long id, Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + id));
        existingAdmin.setName(updatedAdmin.getName());
        existingAdmin.setPhoneN(updatedAdmin.getPhoneN());
        existingAdmin.setPassword(updatedAdmin.getPassword());
        var saved =  adminRepository.save(existingAdmin);
        return adminMapper.toDto(saved);
    }
}
