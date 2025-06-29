package com.example.demo.Clinic;
import org.springframework.stereotype.Service;
@Service
public class ClinicService {

    private  ClinicRepository clinicrepository;

    public  ClinicService (ClinicRepository clinicrepository)
    {
        this.clinicrepository = clinicrepository;
    }


}
