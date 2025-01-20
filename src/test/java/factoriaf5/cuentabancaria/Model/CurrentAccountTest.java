package factoriaf5.cuentabancaria.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentAccountTest {

    @Test
    public void testOverdraftWithdraw() {
        CurrentAccount account = new CurrentAccount(1000, 5.0f);
        account.withdraw(1500);
        assertEquals(0, account.getBalance(), 0.001);
        assertEquals(500, account.getOverdraft(), 0.001);
    }

    @Test
    public void testDepositToOverdraft() {
        CurrentAccount account = new CurrentAccount(0, 5.0f);
        account.withdraw(500); // Overdraft: 500
        account.deposit(300);  // Overdraft reduces to 200
        assertEquals(0, account.getBalance(), 0.001);
        assertEquals(200, account.getOverdraft(), 0.001);
    }

    @Test
    public void testDepositBeyondOverdraft() {
        CurrentAccount account = new CurrentAccount(0, 5.0f);
        account.withdraw(500); // Overdraft: 500
        account.deposit(600);  // Overdraft clears, balance: 100
        assertEquals(100, account.getBalance(), 0.001);
        assertEquals(0, account.getOverdraft(), 0.001);
    }
}
