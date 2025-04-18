package com.dh.ClinicaOdontologica2.controller;

import com.dh.ClinicaOdontologica2.entities.Patient;
import com.dh.ClinicaOdontologica2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Definir el endpoint para crear un nuevo paciente
    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    // Definir el endpoint para buscar un paciente por ID
    @GetMapping("/{id}")
    public Optional<Patient> getById(@PathVariable Integer id) {
        return patientService.findById(id);
    }

    // Definir el endpoint para buscar todos los pacientes
    @GetMapping("/all")
    public List<Patient> getAll() {
        return patientService.findAll();
    }
}
