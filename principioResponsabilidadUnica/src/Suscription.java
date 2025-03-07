public class Suscription implements Saleable {

    private Integer numberOfMonths;
    private Double pricePerMonth;

    public Suscription(Integer numberOfMonths, Double pricePerMonth) {
        this.numberOfMonths = numberOfMonths;
        this.pricePerMonth = pricePerMonth;
    }

    @Override
    public Double calculateTotalPrice() {
        return numberOfMonths * pricePerMonth;
    }
}
