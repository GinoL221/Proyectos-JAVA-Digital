public class TamagochiStateSad implements TamagochiState{
    @Override
    public TamagochiState play() {
        return new TamagochiStateHappy();
    }

    @Override
    public TamagochiState getFood() {
        return this;
    }

    @Override
    public TamagochiState sleep() {
        return this;
    }
}
