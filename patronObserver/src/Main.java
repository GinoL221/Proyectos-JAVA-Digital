public class Main {
    public static void main(String[] args) {
        Reader reader1 = new Reader("John", 25);
        Reader reader2 = new Reader("Mary", 30);
        Reader reader3 = new Reader("Lucy", 28);

        NewsPaper newsPaper = new NewsPaper("The New York Times");

        newsPaper.addObserver(reader1);
        newsPaper.addObserver(reader2);
        newsPaper.addObserver(reader3);

        newsPaper.publish();
    }
}