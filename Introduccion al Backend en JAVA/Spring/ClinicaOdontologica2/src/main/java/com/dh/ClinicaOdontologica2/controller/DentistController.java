package com.dh.ClinicaOdontologica2.controller;

import com.dh.ClinicaOdontologica2.entities.Dentist;
import com.dh.ClinicaOdontologica2.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    // Definir el endpoint para crear un nuevo dentista
    @PostMapping
    public Dentist save(@RequestBody Dentist dentist) {
        return dentistService.save(dentist);
    }

    // Definir el endpoint para buscar un dentista por ID
    @GetMapping("/{id}")
    public Optional<Dentist> getById(@PathVariable Integer id) {
        return dentistService.findById(id);
    }

    // Definir el endpoint para buscar todos los dentistas
    @GetMapping("/all")
    public List<Dentist> getAll() {
        return dentistService.findAll();
    }
}
