package com.example.demo.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController( DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctors")

    public  ResponseEntity<DoctorDTO> addnewdoctor(@RequestBody DoctorinputDTO dto)
    {
        var saveddoctor = doctorService.addnewdoctor(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveddoctor);
    }

    @GetMapping("/doctors/{id}")

    public ResponseEntity<DoctorDTO>  getdoctorbyid( @PathVariable Long id )
    {
        var dto = doctorService.getdoctorbyid(id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/doctors/{id}")

    public void delete (@PathVariable Long id)
    {
        doctorService.deletedoctor(id);
    }


}
