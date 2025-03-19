public class Main {
    public static void main(String[] args){
    User firstUser = new User("John");
    User secondUser = new User("Jane");

    firstUser.spendMoney(400.0);
    secondUser.spendMoney(1000.0);

    System.out.println(firstUser.compareTo(secondUser));
    }
}