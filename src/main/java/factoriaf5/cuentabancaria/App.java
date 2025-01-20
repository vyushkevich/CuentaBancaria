package factoriaf5.cuentabancaria;

import factoriaf5.cuentabancaria.Controller.BankController;
import factoriaf5.cuentabancaria.Model.SavingsAccount;
import factoriaf5.cuentabancaria.View.BankView;

public class App {
    public static void main(String[] args) {
        BankView view = new BankView();
        SavingsAccount account = new SavingsAccount(15000, 3.5f);
        BankController controller = new BankController(account, view);

        controller.start();
    }
}

