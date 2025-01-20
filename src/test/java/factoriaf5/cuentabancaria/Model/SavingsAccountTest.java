package factoriaf5.cuentabancaria.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void depositIncreasesBalance() {
        SavingsAccount account = new SavingsAccount(1000, 3);
        account.deposit(500);
        assertEquals(1500, account.balance);
    }
}
