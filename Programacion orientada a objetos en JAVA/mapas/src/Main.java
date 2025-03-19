import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        Map<String, String> countryCapitals = new HashMap<>();

        countryCapitals.put("Argentina", "Buenos Aires");
        countryCapitals.put("Brazil", "Brasilia");
        countryCapitals.put("Chile", "Santiago");
        countryCapitals.put("Colombia", "Bogota");

        System.out.println(countryCapitals);

        countryCapitals.remove("Colombia");

        System.out.println(countryCapitals);
         */

        Map<Integer, Student> studentMap = new HashMap<>();

        studentMap.put(1, new Student(1, "John", 8.0));
        studentMap.put(2, new Student(2, "Jane", 7.5));
        studentMap.put(3, new Student(3, "Doe", 9.0));
        studentMap.put(4, new Student(4, "Smith", 6.5));

        System.out.println(studentMap);
    }
}