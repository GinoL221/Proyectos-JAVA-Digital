public class Main {
    public static void main(String[] args) {

        Location location1 = new Location(50.0, 100.0);
        Location location2 = new Location(60.0, 250.0);

        Map map = new Map(location1, new MovementStrategyWalking());

        System.out.println(map.calculateTimeToLocation(location2));

        map.setMovementStrategy(new MovementStrategyCar(true));

        map.setMovementStrategy(new MovementStrategyCar(true));

        System.out.println(map.calculateTimeToLocation(location2));
    }
}