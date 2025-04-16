package com.dh.ClinicaOdontologicaSpring.model;

import java.time.LocalDate;

public class Patient {

    private Integer id;
    private String name;
    private String lastName;
    private String cardIdentity;
    private LocalDate admissionDate;

    public Patient(Integer id, String name, String lastName, String cardIdentity, LocalDate admissionDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cardIdentity = cardIdentity;
        this.admissionDate = admissionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardIdentity() {
        return cardIdentity;
    }

    public void setCardIdentity(String cardIdentity) {
        this.cardIdentity = cardIdentity;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}


