package factoriaf5.cuentabancaria.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {

    @Test
    void overdraftActivatedOnWithdraw() {
        CurrentAccount account = new CurrentAccount(1000, 5);
        account.withdraw(1500);
        assertEquals(0, account.balance);
        assertEquals(500, account.overdraft);
    }

    @Test
    void depositRepaysOverdraft() {
        CurrentAccount account = new CurrentAccount(0, 5);
        account.overdraft = 500;
        account.deposit(600);
        assertEquals(100, account.balance);
        assertEquals(0, account.overdraft);
    }
}
