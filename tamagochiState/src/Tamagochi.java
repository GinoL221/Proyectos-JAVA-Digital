public class Tamagochi  {
    private String name;
    private TamagochiState currentState;

    public Tamagochi(String name) {
        this.name = name;
        currentState = new TamagochiStateHappy();
    }

    public void play() {
        this.currentState = this.currentState.play();
    }

    public void getFood() {
        this.currentState = this.currentState.getFood();
    }

    public void sleep() {
        this.currentState = this.currentState.sleep();
    }

    public TamagochiState getCurrentState() {
        return currentState;
    }
}
