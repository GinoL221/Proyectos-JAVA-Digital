package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Person> people;

    public Group() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        boolean isAdult = person.isAdult();
        boolean name5Check = person.name5Check();
        boolean nameAZCheck = person.nameAZCheck();
        boolean ageCheck = person.ageCheck();

        if (isAdult && name5Check && nameAZCheck && ageCheck) {
            people.add(person);
            System.out.println("Person added successfully: " + person.getName());
        } else {
            System.err.println("Error: Person does not meet the criteria : " + person.getName());
            if (!isAdult) {
                System.err.println("Person is not an adult.");
            }
            if (!name5Check) {
                System.err.println("Name must have at least 5 characters.");
            }
            if (!nameAZCheck) {
                System.err.println("Name must contain only letters from A to Z.");
            }
            if (!ageCheck) {
                System.err.println("Age must be between 0 and 120.");
            }
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
