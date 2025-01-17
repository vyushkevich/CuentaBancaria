package factoriaf5.cuentabancaria.Model;

public class Account {
    protected float balance;
    protected int depositCount;
    protected int withdrawalCount;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float initialBalance, float annualInterestRate) {
        this.balance = initialBalance;
        this.annualInterestRate = annualInterestRate;
        this.depositCount = 0;
        this.withdrawalCount = 0;
        this.monthlyFee = 0;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            depositCount++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            withdrawalCount++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterest = (annualInterestRate / 12) / 100 * balance;
        balance += monthlyInterest;
    }

    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
        monthlyFee = 0;
    }

    public String printDetails() {
        return String.format(
            "Balance: %.2f\nMonthly Fee: %.2f\nDeposits: %d\nWithdrawals: %d",
            balance, monthlyFee, depositCount, withdrawalCount
        );
    }
}
