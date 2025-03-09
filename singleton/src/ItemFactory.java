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
}
