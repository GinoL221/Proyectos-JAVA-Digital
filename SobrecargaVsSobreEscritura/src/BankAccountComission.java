public class BankAccountComission extends BankAccount {
    private Double comission;

    public BankAccountComission(String accountOwner, Double comission) {
        super(accountOwner);
        this.comission = comission;
    }

    @Override
    public void withdraw(Double amount) {
        Double realWhitdraw = amount - (amount * comission);
        super.withdraw(realWhitdraw);
    }

    @Override
    public void deposit(Double amount) {
        super.deposit(amount);
    }
}
