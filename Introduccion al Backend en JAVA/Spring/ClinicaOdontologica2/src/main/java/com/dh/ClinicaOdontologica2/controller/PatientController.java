package com.dh.ClinicaOdontologica2.controller;

import com.dh.ClinicaOdontologica2.entities.Patient;
import com.dh.ClinicaOdontologica2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // localhost:8080/patient/save
    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    // Definir el endpoint para buscar un paciente por ID
    // localhost:8080/patient/1
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Integer id) {
        Optional<Patient> optionalPatient = patientService.findById(id);
        if (optionalPatient.isPresent()) {
            return ResponseEntity.ok(optionalPatient.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Definir el endpoint para buscar todos los pacientes
    // localhost:8080/patient/all
    @GetMapping("/all")
    public List<Patient> getAll() {
        return patientService.findAll();
    }

    // Definir el endpoint para actualizar un paciente
    // localhost:8080/patient/1
    @PutMapping("/update")
    public Patient update(@RequestBody Patient patient) {
        Optional<Patient> optionalPatient = patientService.findById(patient.getId());
        if (optionalPatient.isPresent()) {
            patientService.update(patient);
            return patient;
        } else {
            return patient;
        }
    }

    // Definir el endpoint para eliminar un paciente
    // localhost:8080/patient/1
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Patient> optionalPatient = patientService.findById(id);
        if (optionalPatient.isPresent()) {
            patientService.delete(id);
            return "El paciente con id:" + id + " eliminado";
        } else {
            return "El paciente con id:" + id + " no fue encontrado";
        }
    }

    // Consultar paciente por apellido
    @GetMapping("/lastName/{lastName}")
    public Patient findByLastName(@PathVariable String lastName) {
        Optional<Patient> optionalPatient = patientService.findByLastName(lastName);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    // Consultar paciente por nombre
    @GetMapping("/name/{name}")
    public Patient findByName(@PathVariable String name) {
        Optional<Patient> optionalPatient = patientService.findByName(name);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }
}
