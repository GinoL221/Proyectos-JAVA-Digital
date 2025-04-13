import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class EmployeeFileHandler {

    public static void saveEmployeeSpecialFormat(List<Employee> employeeList) {
        // Vamos a guardar -> flujo de salida
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("empleados.txt");

            // Necesitamos guardar, vamos a usar un buffer
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            for (Employee e : employeeList) {
                String employeeString = e.toString() + "\n";
                bos.write(employeeString.getBytes());
            }

            bos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
