public abstract class BankAccount {
    private String accountOwner;
    private Double balance;

    public BankAccount(String accountOwner) {
        this.accountOwner = accountOwner;
        this.balance = 0.0;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public Double getBalance() {
        return balance;
    }

    public Boolean canWithdraw(Double amount) {
        return balance >= amount;
    }
}
