package com.example.demo.Patient;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController

public class PatientController {

    private final PatientService patientService;

    // Constructor Injection
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientDto> addPatient(@Valid @RequestBody PatientinputDto dto) {
        var savedPatient = patientService.addPatient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }



    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable
                                          Long id) {
        PatientDto dto = patientService.getPatientById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<PatientDto>> getPatientByName(  @RequestParam  String name)
    {
        List<PatientDto> result = patientService.getPatientByName(name);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Long id)
    {
        patientService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    )
    {
        var errors = new HashMap<String,String>();

        exp.getBindingResult().getAllErrors().forEach(

                error ->{
                    var fieldname = ((FieldError)error).getField();
                    var errormessage = error.getDefaultMessage();
                    errors.put(fieldname,errormessage);
                }
        );

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}

