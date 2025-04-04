package ejercicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupTest {

    /*
    Dadas 5 personas, (Juan, Pedro, Ana, Luz y Julián) y una coleccion vacia de objetos tipo Persona,
    cuando se intentan agregar estas a la coleccion, el tamaño de la colección debe ser 2
     */
    @Test
    public void caseOne() {
        //Dado:
        Person juan = new Person("Juan", 22);
        Person pedro = new Person("Pedro", 32);
        Person ana = new Person("Ana", 23);
        Person luz = new Person("Luz", 21);
        Person julian = new Person("Julian", 35);

        Group group = new Group();

        //Cuando:
        group.addPerson(juan);
        group.addPerson(pedro);
        group.addPerson(ana);
        group.addPerson(luz);
        group.addPerson(julian);


        //Entonces -> el tamaño de la coleccion es 2
        Assertions.assertTrue(group.getPeople().size() == 2);
    }

    /*
    Dadas 5 personas, (18 años, 17 años, 22 años, 14 años y 32 años) el tamaño de la coleccion es 3
     */
    @Test
    public void caseTwo() {
        //Dado:
        Person person1 = new Person("Javier", 18);
        Person person2 = new Person("Pablo", 17);
        Person person3 = new Person("Esteban", 22);
        Person person4 = new Person("Carlos", 14);
        Person person5 = new Person("Francisca", 32);

        Group group = new Group();

        //Cuando:
        group.addPerson(person1);
        group.addPerson(person2);
        group.addPerson(person3);
        group.addPerson(person4);
        group.addPerson(person5);

        // Entonces -> el tamaño de la coleccion es 3
        Assertions.assertTrue(group.getPeople().size() == 3);
    }

    /*
    Dadas 5 personas, (N1colas, Tomas, 3steban, Carlos\sV, Francisco\sII) el tamaño de la colección debería ser de 1
     */
    @Test
    public void caseThree() {
        //Dado:
        Person person1 = new Person("N1colas", 18);
        Person person2 = new Person("Tomas", 25);
        Person person3 = new Person("3steban", 27);
        Person person4 = new Person("Carlos\\sV", 13);
        Person person5 = new Person("Francisco\\II", 39);

        Group group = new Group();

        //Cuando:
        group.addPerson(person1);
        group.addPerson(person2);
        group.addPerson(person3);
        group.addPerson(person4);
        group.addPerson(person5);

        // Entonces -> el tamaño de la coleccion es 3
        Assertions.assertEquals(1, group.getPeople().size());
    }
}