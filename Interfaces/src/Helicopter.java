public class Helicopter extends Vehicle implements Flyable{

    public Helicopter(String color) {
        super(0, color);
    }

    @Override
    public void fly() {
        if(itsOn){
            System.out.println("The helicopter is flying.");
        }
    }
}
