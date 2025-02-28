public class Check {
    private String checkOwner;
    private Double amount;

    public Check(String checkOwner, Double amount) {
        this.amount = amount;
        this.checkOwner = checkOwner;
    }

    public Double getAmount() {
        return amount;
    }
}
