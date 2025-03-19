import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //creation
        List<Integer> numberList = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();

        //adding elements
        numberList.add(9);
        numberList.add(3);
        numberList.add(5);
        numberList.add(3);

        numberSet.add(9);
        numberSet.add(3);
        numberSet.add(5);
        numberSet.add(3); //no se agrega porque ya existe, set no permite repetidos

        //size
        System.out.println(numberList.size());
        System.out.println(numberSet.size());

        //get
        System.out.println(numberList.get(1));
        /*
        System.out.println(numberSet.get()); //no existe el metodo get en Set
        */

        //iteration
        for (Integer number : numberList){
            System.out.println(number);
        }

        for(Integer number : numberSet){
            System.out.println(number);
        }

        //printing
        System.out.println(numberList);
        System.out.println(numberSet);
    }
}