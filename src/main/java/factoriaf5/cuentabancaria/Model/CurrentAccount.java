package factoriaf5.cuentabancaria.Model;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount > balance) {
            overdraft += (amount - balance);
            balance = 0;
        } else {
            balance -= amount;
        }
        withdrawalCount++;
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                balance += (amount - overdraft);
                overdraft = 0;
            } else {
                overdraft -= amount;
            }
        } else {
            super.deposit(amount);
        }
    }

    @Override
    public String printDetails() {
        return super.printDetails() + String.format("\nOverdraft: %.2f", overdraft);
    }
}
