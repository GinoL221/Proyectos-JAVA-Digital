import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        List<Integer> numberList = new ArrayList<>();

        numberList.add(2);
        numberList.add(3);
        numberList.add(5);

        try{
            numberList.get(5);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("No existe el elemento con ese indice");
        }catch (Exception e){
            System.out.println("Ocurrió un error");
        }

        System.out.println("Llego hasta aca");
         */

        ShoppingCart shoppingCart = new ShoppingCart();

        try {
            shoppingCart.addProduct(new Product("Remera",100.0));
            shoppingCart.addProduct(new Product("Pantalon",200.0));
            shoppingCart.addProduct(new Product("Zapatillas",300.0));
            shoppingCart.addProduct(null);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}