public class Main {
    public static void main(String[] args) {
        ProductTicketDataBase productTicketDataBase = new ProductTicketDataBase();

        productTicketDataBase.addProductTicket(new ProductTicket("Banana", 2, 10.0));
        productTicketDataBase.addProductTicket(new ProductTicket("Apple", 3, 5.0));
        productTicketDataBase.addProductTicket(new ProductTicket("Orange", 4, 7.0));

        try {
            productTicketDataBase.addProductTicket(new ProductTicketLimitedAmount("Mango", 5, 8.0, 10));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProductTicket productTicket = new ProductTicketWithTax("Pineapple", 6, 9.0, 0.21);

        productTicket = new ProductTicketStandard("Melon", 7, 10.0);

        System.out.println(productTicketDataBase.calculateTotalEarnings());
    }
}