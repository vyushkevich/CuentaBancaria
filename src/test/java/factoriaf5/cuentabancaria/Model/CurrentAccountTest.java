package factoriaf5.cuentabancaria.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositIncreasesBalance() {
        Account account = new Account(1000, 5);
        account.deposit(500);
        assertEquals(1500, account.balance);
    }

    @Test
    void withdrawDecreasesBalance() {
        Account account = new Account(1000, 5);
        account.withdraw(300);
        assertEquals(700, account.balance);
    }

    @Test
    void withdrawDoesNotExceedBalance() {
        Account account = new Account(1000, 5);
        account.withdraw(2000);
        assertEquals(1000, account.balance);
    }

    @Test
    void monthlyStatementCalculatesInterest() {
        Account account = new Account(1200, 6);
        account.monthlyStatement();
        assertEquals(1206, account.balance, 0.1); // учитываем проценты
    }
}
