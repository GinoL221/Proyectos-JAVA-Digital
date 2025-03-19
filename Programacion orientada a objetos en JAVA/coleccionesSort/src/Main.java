import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        List<Integer> numbersList = new ArrayList<>();

        numbersList.add(4);
        numbersList.add(1);
        numbersList.add(3);
        numbersList.add(2);
        numbersList.add(5);

        numbersList.sort(null);

        System.out.println(numbersList);
        */

        List<Worker> workerList = new ArrayList<>();

        workerList.add(new Worker("John", 40));
        workerList.add(new Worker("Alice", 20));
        workerList.add(new Worker("Bob", 30));

        workerList.sort(null);

        System.out.println(workerList);

    }
}