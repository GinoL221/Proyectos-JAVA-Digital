public class Main {
    public static void main(String[] args) {

        ItemFactory itemFactory = ItemFactory.getInstance();
        ItemFactory anotherItemFactory = ItemFactory.getInstance();

        System.out.println(itemFactory.equals(anotherItemFactory));

        Shop shop = new Shop();

        shop.addItem(itemFactory.createItem(1));
        shop.addItem(itemFactory.createItem(2));
        shop.addItem(itemFactory.createItem(3));

        System.out.println("Total price: "+shop.calculatePrice());
    }
}