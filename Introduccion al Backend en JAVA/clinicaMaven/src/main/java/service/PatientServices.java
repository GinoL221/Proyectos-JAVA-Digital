package service;

import dao.IDao;
import model.Patient;

import java.util.List;

public class PatientServices {

    private IDao<Patient> patientIDao;

    public PatientServices(IDao<Patient> patientIDao) {
        this.patientIDao = patientIDao;
    }

    public Patient save(Patient patient) {
        return patientIDao.save(patient);
    }

    public Patient findById(Integer id) {
        return patientIDao.findById(id);
    }

    public void update(Patient patient) {
        patientIDao.update(patient);
    }

    public void delete(Integer id) {
        patientIDao.delete(id);
    }

    public List<Patient> findAll() {
        return patientIDao.findAll();
    }
}
