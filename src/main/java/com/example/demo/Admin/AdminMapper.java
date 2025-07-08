package com.example.demo.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Builder
public class AdminMapper {

    public AdminDto toDto(Admin admin) {
        return new AdminDto(
                admin.getId(),
                admin.getName(),
                admin.getPhoneN()

        );
    }

    public Admin fromInputDto(AdminInputDto dto) {
        return new Admin(
                dto.name()
                , dto.phoneN()
                , dto.password()
                );
    }
}
