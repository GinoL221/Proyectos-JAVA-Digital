package com.dh.testDB.controller;

import com.dh.testDB.entities.Student;
import com.dh.testDB.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // El estudiante llega desde el cliente en el cuerpo de la petición
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    // El cliente no envía nada, el servidor responde con todos los estudiantes
    @GetMapping("/all")
    public List<Student> getAll() {
        return studentService.getAll();
    }

}
