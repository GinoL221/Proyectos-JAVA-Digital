import java.util.ArrayList;
import java.util.List;

public class ProductComposite extends Product{

    private List<Product> productList;
    private Double discount;

    public ProductComposite(String name, Double discount) {
        super(name);
        productList = new ArrayList<>();
        this.discount = discount;
    }

    public void addProduct(Product product){
        productList.add(product);
    }



    @Override
    public Double calculatePrice() {
        Double totalPrice = 0.0;
        Double totalPriceDiscount = 0.0;
        for (Product product : productList) {
            totalPrice += product.calculatePrice();
        }
        totalPriceDiscount = totalPrice - (totalPrice*discount);
        return totalPriceDiscount;
    }
}
