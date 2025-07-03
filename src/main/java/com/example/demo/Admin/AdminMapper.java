package com.example.demo.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Builder
public class AdminMapper {

    public AdminDto toDto(Admin admin) {
        return AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .build();
    }

    public Admin fromInputDto(AdminInputDto dto) {
        return Admin.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
