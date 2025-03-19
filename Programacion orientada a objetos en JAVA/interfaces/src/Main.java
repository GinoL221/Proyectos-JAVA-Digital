public class Main {
    public static void main(String[] args) {
        Helicopter helicopter = new Helicopter("red");

        helicopter.turnOn();
        helicopter.fly();

        Bird bird = new Bird();

        bird.fly();
    }
}