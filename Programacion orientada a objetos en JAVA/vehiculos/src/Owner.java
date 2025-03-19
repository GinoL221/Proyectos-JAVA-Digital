public class Owner {

    private String name;
    private Vehicle vehicle;

    public Owner(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
