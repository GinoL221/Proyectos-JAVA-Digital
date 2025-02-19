public class VehicleMoto extends Vehicle {

    private String brandName;

    public VehicleMoto(String licencePlate, String color, String brandName) {
        super(licencePlate, color, 2);
        this.brandName = brandName;
    }
}
