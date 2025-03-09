public class ItemFactory {

    private static ItemFactory instance;

    private ItemFactory(){

    }

    public static ItemFactory getInstance(){
        if(instance == null){
            instance = new ItemFactory();
        }
        return instance;
    }

    public Item createItem(Integer id){
        return switch (id) {
            case 1 -> new Item("Hamburger", 30.0);
            case 2 -> new Item("French Fries", 15.0);
            case 3 -> new Item("Ice Cream", 10.0);
            default -> null;
        };
    }
}
