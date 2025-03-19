import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Observable{

    private String name;
    private List<Observer> suscribersList;

    public NewsPaper(String name) {
        this.name = name;
        suscribersList = new ArrayList<>();
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer : suscribersList){
            observer.update();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        suscribersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        suscribersList.remove(observer);
    }

    public void publish(){
        System.out.println("New edition of " + this.name + " is out!");
        notifyAllObservers();
    }
}
