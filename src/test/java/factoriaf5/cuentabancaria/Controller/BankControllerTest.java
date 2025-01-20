package factoriaf5.cuentabancaria.Controller;

import factoriaf5.cuentabancaria.Model.Account;
import factoriaf5.cuentabancaria.View.BankView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BankControllerTest {

    @Test
    void startCallsMenuOptions() {
        Account mockAccount = mock(Account.class);
        BankView mockView = mock(BankView.class);

        when(mockView.showMenu()).thenReturn(1, 0); // 1 для депозита, 0 для выхода
        when(mockView.requestAmount(anyString())).thenReturn(100f);

        BankController controller = new BankController(mockAccount, mockView);
        controller.start();

        verify(mockView, times(2)).showMenu();
        verify(mockAccount).deposit(100f);
    }
}
