package com.example.demo.Doctor;

public class DoctorMapper {

    public static  Doctor todoctor(DoctorinputDTO dto)
    {
         return  new Doctor(dto.name(),dto.speciality(),dto.phone());
    }

    public static  DoctorDTO todto(Doctor dr)
    {
        return  new DoctorDTO(dr.getId(), dr.getName(), dr.getSpeciality());
    }
}
