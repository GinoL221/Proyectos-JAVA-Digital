package com.dh.dentalClinicMVC.controller;

import org.springframework.ui.Model;
import com.dh.dentalClinicMVC.model.Patient;
import com.dh.dentalClinicMVC.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Este método maneja las solicitudes GET a la ruta "/patients"
    @GetMapping
    public String findPatientByEmail(Model model, @RequestParam("email") String email) {
        Patient patient = patientService.findByEmail(email);
        model.addAttribute("name", patient.getName());
        model.addAttribute("lastName", patient.getLastName());
        return "index"; // Retorna la vista "index" con los atributos del paciente
    }

}

