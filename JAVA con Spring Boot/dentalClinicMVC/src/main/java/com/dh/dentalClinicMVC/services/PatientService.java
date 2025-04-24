package com.dh.dentalClinicMVC.services;

import com.dh.dentalClinicMVC.dao.IDao;
import com.dh.dentalClinicMVC.dao.PatientDaoH2;
import com.dh.dentalClinicMVC.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private IDao<Patient> patientIDao;

    public PatientService() {
        this.patientIDao = new PatientDaoH2();
    }

    public Patient save(Patient patient) {
        return patientIDao.save(patient);
    }

    public Patient findById(Integer id) {
        return patientIDao.findById(id);
    }

    public void delete(Integer id) {
        patientIDao.delete(id);
    }

    public void update(Patient patient) {
        patientIDao.update(patient);
    }

    public IDao<Patient> getPatientIDao() {
        return patientIDao;
    }

    public Patient findByEmail(String email) {
        return patientIDao.findByString(email);
    }
}
