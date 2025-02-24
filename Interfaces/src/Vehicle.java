public class Vehicle {
    private Integer numberOfWheels;
    private String color;
    protected Boolean itsOn;

    public Vehicle(Integer numberOfWheels, String color) {
        this.numberOfWheels = numberOfWheels;
        this.color = color;
        this.itsOn = false;
    }

    public void turnOn() {
        if(!itsOn){
            this.itsOn = true;
            System.out.println("The vehicle is now on.");
        }else{
            System.out.println("The vehicle is already on.");
        }
    }
}
