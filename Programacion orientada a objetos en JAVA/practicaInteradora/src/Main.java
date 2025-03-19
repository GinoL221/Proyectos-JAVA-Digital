public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new VehicleStandar("ABC123", "Red");
        Vehicle vehicleDeluxe = new VehicleDeluxe("XYZ987", "Black", 3.0);

        Driver driver = new Driver("John Doe", vehicle);

        driver.howMuchForTrip(10.0);
        driver.howMuchForTrip(66.0);

        driver.setVehicle(vehicleDeluxe);
        driver.howMuchForTrip(30.0);
    }
}