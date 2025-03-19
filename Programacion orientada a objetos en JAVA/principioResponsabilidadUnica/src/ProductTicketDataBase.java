import java.util.ArrayList;
import java.util.List;

public class ProductTicketDataBase {

    private List<Saleable> productTicketList;

    public ProductTicketDataBase() {
        productTicketList = new ArrayList<>();
    }

    public void addProductTicket(Saleable saleable) {
        productTicketList.add(saleable);
    }

    public Double calculateTotalEarnings() {
        Double totalPrice = 0.0;
        for (Saleable productTicket : productTicketList) {
            totalPrice += productTicket.calculateTotalPrice();
        }
        return totalPrice;
    }
}
