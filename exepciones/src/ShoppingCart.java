import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) throws Exception{
        if(product == null){
            throw new ShoppingCartException("El producto no puede ser nulo");
        }
        productList.add(product);
    }
}
