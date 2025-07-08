package com.example.demo.Doctor;

import com.example.demo.Exceptions.DuplicateResourceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final  DoctorRepository doctorRepository;

    public  DoctorService(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }

    public DoctorDTO addnewdoctor(DoctorinputDTO dto)
    {
        if (doctorRepository.existesByPhone(dto.phone()))
            throw new DuplicateResourceException("This phone is existed");
        var doctor = DoctorMapper.todoctor(dto);
        var saved = doctorRepository.save(doctor);
        return DoctorMapper.todto(saved);
    }

    public List<DoctorDTO> getalldoctors()
    {
        List<Doctor> doctors = doctorRepository.findAll();

        return doctors.stream().map(DoctorMapper::todto).collect(Collectors.toList());
    }

    public DoctorDTO getdoctorbyid(Long id)
    {
        Doctor dr = doctorRepository.findById(id).orElseThrow(() ->
               new IllegalStateException("doctor with id + "+ id+" not found"));
        return DoctorMapper.todto(dr);
    }

    public void deletedoctor(Long id)
    {
        doctorRepository.deleteById(id);
    }
}
