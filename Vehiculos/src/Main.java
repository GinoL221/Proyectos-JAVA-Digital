public class Main {
    public static void main(String[] args) {
        VehicleCar car = new VehicleCar("ABC123", "Red");
        VehicleMoto moto = new VehicleMoto("XYZ123", "Black", "Yamaha");
        Owner owner = new Owner("John", car);
    }
}