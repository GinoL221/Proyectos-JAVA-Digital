public class ProductTicketLimitedAmount extends ProductTicket {
    private Integer maxAmount;

    public ProductTicketLimitedAmount(String productName, Integer quantity, Double pricePerProduct, Integer maxAmount) throws LimitedAmountException {
        super(productName, quantity, pricePerProduct);
        if (quantity > maxAmount) {
            throw new LimitedAmountException("Quantity is greater than max amount");
        }
        this.maxAmount = maxAmount;

    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }
}
