package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Ejercicio
    Se desea persistir un listado de perros en un archivo. Los perros tienen un nombre y una edad.
    Probar en el método main guardar toda la colección de perros en un archivo.
    Luego, recuperar -en otra colección- el contenido del archivo para mostrar la colección por consola.
     */
    public static void main(String[] args) {
        // Necesitamos una lista de perros
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "Branca"));
        dogs.add(new Dog(12, "Toby"));
        dogs.add(new Dog(7, "Luna"));
        dogs.add(new Dog(4, "Rocco"));

        // Necesitamos un archivo donde guardar los perros
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Salida.txt");

            // Necesitamos un objeto que nos permita escribir en el archivo
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Necesitamos escribir la lista de perros en el archivo
            oos.writeObject(dogs);
            // Necesitamos cerrar el objeto de salida
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Necesitamos recuperar la lista y mostrarla por pantalla
        List<Dog> dogsFromFile = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("Salida.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Necesitamos leer la lista de perros del archivo
            dogsFromFile = (ArrayList) ois.readObject();
            // Necesitamos cerrar el objeto de entrada
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Dog dog : dogsFromFile) {
            System.out.println(dog);
        }
    }
}
