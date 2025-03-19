public class BankAccountOverdraft extends BankAccount{
    private Double extraAmountWhithdrawable;

    public BankAccountOverdraft(String accountOwner, Double extraAmountWhithdrawable) {
        super(accountOwner);
        this.extraAmountWhithdrawable = extraAmountWhithdrawable;
    }

    @Override
    public void withdraw(Double amount) {
        if(canWithdraw(amount)){
            super.withdraw(amount);
        }
    }

    @Override
    public Boolean canWithdraw(Double amount) {
        return getBalance() + extraAmountWhithdrawable > amount ;
    }
}
