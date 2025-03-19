public class Main {
    public static void main(String[] args) {
        Tamagochi tamagochi = new Tamagochi("Tamagochi");

        System.out.println(tamagochi.getCurrentState());
        tamagochi.play();
        System.out.println(tamagochi.getCurrentState());
        tamagochi.getFood();
        System.out.println(tamagochi.getCurrentState());
        tamagochi.sleep();
        System.out.println(tamagochi.getCurrentState());
    }
}