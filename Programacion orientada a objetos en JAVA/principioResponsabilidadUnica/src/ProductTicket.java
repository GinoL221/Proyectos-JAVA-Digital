public class ProductTicket implements Saleable {
    private String productName;
    private Integer quantity;
    private Double pricePerProduct;

    public ProductTicket(String productName, Integer quantity, Double pricePerProduct) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerProduct = pricePerProduct;
    }

    public Double calculateTotalPrice() {
        return quantity * pricePerProduct;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPricePerProduct() {
        return pricePerProduct;
    }
}
