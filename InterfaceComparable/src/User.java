public class User implements Comparable<User> {

    private String name;
    private Double moneyExpended;

    public User(String name) {
        this.name = name;
        moneyExpended = 0.0;
    }

    public void spendMoney(Double amount){
        moneyExpended += amount;
    }

    @Override
    public int compareTo(User anotherUser) {
        if (this.moneyExpended > anotherUser.moneyExpended) {
            return 1;
        }
        if (this.moneyExpended < anotherUser.moneyExpended) {
            return -1;
        }
        return 0;
    }
}
