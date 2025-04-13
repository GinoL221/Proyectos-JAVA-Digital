import dao.BD;
import dao.impl.DentistDaoH2;
import model.Dentist;
import service.DentistService;

public class Main {
    public static void main(String[] args) {

        DentistService dentistService = new DentistService(new DentistDaoH2());

        // Creamos las tablas
        BD.createTable();

        // Creams algunos objetos
        Dentist dentist1 = new Dentist(123, "Juan", "Pérez");
        Dentist dentist2 = new Dentist(456, "Ana", "Gómez");
        Dentist dentist3 = new Dentist(789, "Luis", "Martínez");
        Dentist dentist4 = new Dentist(101, "María", "López");

        // Persistir los objetos en la base de datos
        dentistService.save(dentist1);
        dentistService.save(dentist2);
        dentistService.save(dentist3);
        dentistService.save(dentist4);

        // Consultar un odontologo por ID
        int id = 2;
        dentistService.findById(id);

        // Actualizar algunos de los atributos de un odontólogo
        String updateName = "Juan Carlos";
        dentist1.setName(updateName);

        dentistService.update(dentist1);
        System.out.println("El nombre actualizado es: " + dentist1.getName());

        // Borrar alguno de los registros de la tabla
        int idDelete = 2;
        dentistService.delete(idDelete);
        System.out.println("El odontólogo con ID " + idDelete + " ha sido eliminado.");

        // Lista de odontólogos
        dentistService.findAll();
    }
}
