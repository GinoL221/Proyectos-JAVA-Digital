public class ProductTicketWithTax extends ProductTicket {
    private Double tax;

    public ProductTicketWithTax(String productName, Integer quantity, Double pricePerProduct, Double tax) {
        super(productName, quantity, pricePerProduct);
        this.tax = tax;
    }

    @Override
    public Double calculateTotalPrice() {
        return super.calculateTotalPrice() + super.calculateTotalPrice() * tax;
    }
}
