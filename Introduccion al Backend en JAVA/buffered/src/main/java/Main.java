import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /* Ejercicio
        2.	Crear un clase Empleado con los atributos: nombre, apellido, legajo, sueldo.
            Guardar empleados en un archivo "empleados.txt", pero sin utilizar la clase ObjectOutputStream,
            ya que deben guardarse todos los atributos de los empleados separados por una coma (",").
    */
    public static void main(String[] args) {
        // Crear una lista de empleados
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Juan", "Pérez", 123, 50000.0));
        list.add(new Employee("Ana", "Gómez", 456, 60000.0));
        list.add(new Employee("Luis", "Martínez", 789, 70000.0));
        list.add(new Employee("María", "López", 101, 80000.0));
        list.add(new Employee("Pedro", "García", 112, 90000.0));

        // Guardar los empleados en un archivo
        EmployeeFileHandler.saveEmployeeSpecialFormat(list);
        
    }
}
