public class Main {
    public static void main(String[] args) {

        ItemFactory itemFactory = ItemFactory.getInstance();
        ItemFactory anotherItemFactory = ItemFactory.getInstance();

        System.out.println(itemFactory.equals(anotherItemFactory));
    }
}