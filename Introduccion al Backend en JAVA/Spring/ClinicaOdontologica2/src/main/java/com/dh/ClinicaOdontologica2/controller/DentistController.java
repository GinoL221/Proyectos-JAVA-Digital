package com.dh.ClinicaOdontologica2.controller;

import com.dh.ClinicaOdontologica2.entities.Dentist;
import com.dh.ClinicaOdontologica2.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // localhost:8080/dentist/save
    @PostMapping("/save")
    public Dentist save(@RequestBody Dentist dentist) {
        return dentistService.save(dentist);
    }

    // Definir el endpoint para buscar un dentista por ID
    // localhost:8080/dentist/1
    @GetMapping("/{id}")
    public ResponseEntity<Dentist> getById(@PathVariable Integer id) {
        Optional<Dentist> optionalDentist = dentistService.findById(id);
        if (optionalDentist.isPresent()) {
            return ResponseEntity.ok(optionalDentist.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Definir el endpoint para buscar todos los dentistas
    // localhost:8080/dentist/all
    @GetMapping("/all")
    public List<Dentist> getAll() {
        return dentistService.findAll();
    }

    // Definir el endpoint para actualizar un dentista
    // localhost:8080/dentist/1
    @PutMapping("/update")
    public Dentist update(@RequestBody Dentist dentist) {
        Optional<Dentist> optionalDentist = dentistService.findById(dentist.getId());
        if (optionalDentist.isPresent()) {
            dentistService.update(dentist);
            return dentist;
        } else {
            return dentist;
        }
    }

    // Definir el endpoint para eliminar un dentista
    // localhost:8080/dentist/delete/1
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Dentist> optionalDentist = dentistService.findById(id);
        if (optionalDentist.isPresent()) {
            dentistService.delete(id);
            return "Dentista con id:" + id + " eliminado correctamente";
        } else {
            return "El dentista con id:" + id + " no existe";
        }
    }
}
