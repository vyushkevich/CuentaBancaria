package factoriaf5.cuentabancaria.View;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankViewTest {

    @Test
    void showMenuReturnsValidOption() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BankView view = new BankView();
        int option = view.showMenu();
        assertEquals(1, option);
    }

    @Test
    void requestAmountReturnsEnteredValue() {
        String input = "500\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BankView view = new BankView();
        float amount = view.requestAmount("Enter deposit amount: ");
        assertEquals(500, amount);
    }

    @Test
    void displayMessagePrintsMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BankView view = new BankView();
        view.displayMessage("Test message");

        assertEquals("Test message\n", outContent.toString());
    }
}
