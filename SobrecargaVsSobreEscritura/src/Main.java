public class Main {
    public static void main(String[] args) {
        BankAccountComission bankAccountComission = new BankAccountComission("Juan",0.01);
        BankAccountOverdraft bankAccountOverdraft = new BankAccountOverdraft("Pedro",1000.0);

        bankAccountOverdraft.deposit(700.0);
        bankAccountComission.deposit(700.0);

        bankAccountOverdraft.withdraw(1200.0);
        bankAccountComission.withdraw(100.0);

        Check check = new Check("Nicolas",3000.0);

        bankAccountComission.deposit(check);
    }
}
