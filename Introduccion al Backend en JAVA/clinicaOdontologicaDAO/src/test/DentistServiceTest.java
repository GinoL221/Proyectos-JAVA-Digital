package test;

import dao.BD;
import dao.impl.DentistDaoH2;
import model.Dentist;
import org.junit.jupiter.api.Test;
import service.DentistService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceTest {

    DentistService dentistService = new DentistService(new DentistDaoH2());

    @Test
    void save() {
        BD.createTable();
        Dentist dentist = new Dentist();
        dentist.setRegistrationNumber(555);
        dentist.setName("Carolina");
        dentist.setLastName("Garro");

        dentistService.save(dentist);

        assertNotNull(dentist.getId());
    }

    @Test
    void findById() {
        Dentist dentist = dentistService.findById(1);
        assertNotNull(dentist);
    }

    @Test
    void update() {
        Dentist dentist = new Dentist();
        dentist.setId(1);
        dentist.setRegistrationNumber(777);
        dentist.setName("Veronica");
        dentist.setLastName("Garcia");
        dentistService.update(dentist);

        assertNotNull(dentist.getId());
        assertEquals(true, dentist.getName().equals("Veronica"));
    }

    @Test
    void delete() {
        Dentist dentistDeleted = dentistService.findById(2);

        assertNull(dentistDeleted);
    }

    @Test
    void findAll() {
        List<Dentist> dentistList = dentistService.findAll();

        assertTrue(dentistList.size() > 0);
    }
}