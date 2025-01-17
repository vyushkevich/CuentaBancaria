package factoriaf5.cuentabancaria.Model;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.isActive = initialBalance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
            checkStatus();
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive && amount <= balance) {
            super.withdraw(amount);
            checkStatus();
        }
    }

    @Override
    public void monthlyStatement() {
        if (withdrawalCount > 4) {
            monthlyFee += (withdrawalCount - 4) * 1000;
        }
        super.monthlyStatement();
        checkStatus();
    }

    private void checkStatus() {
        isActive = balance >= 10000;
    }

    @Override
    public String printDetails() {
        return super.printDetails() + String.format("\nAccount Active: %b", isActive);
    }
}
