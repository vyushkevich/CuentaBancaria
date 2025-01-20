package factoriaf5.cuentabancaria.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testDeposit() {
        Account account = new Account(1000, 5.0f);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        Account account = new Account(1000, 5.0f);
        account.withdraw(300);
        assertEquals(700, account.getBalance(), 0.001);
    }

    @Test
    public void testCalculateMonthlyInterest() {
        Account account = new Account(1000, 12.0f); // 12% annual interest
        account.calculateMonthlyInterest();
        assertEquals(1010, account.getBalance(), 0.001); // 1% monthly interest
    }
}
