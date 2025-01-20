package factoriaf5.cuentabancaria.Controller;

import factoriaf5.cuentabancaria.Model.*;
import factoriaf5.cuentabancaria.View.BankView;

public class BankController {
    private Account account;
    private BankView view;

    public BankController(Account account, BankView view) {
        this.account = account;
        this.view = view;
    }

    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    float depositAmount = view.requestAmount("Enter deposit amount: ");
                    account.deposit(depositAmount);
                    view.displayMessage("Deposit successful.");
                    break;
                case 2:
                    float withdrawAmount = view.requestAmount("Enter withdrawal amount: ");
                    account.withdraw(withdrawAmount);
                    view.displayMessage("Withdrawal successful.");
                    break;
                case 3:
                    account.monthlyStatement();
                    view.displayMessage("Monthly statement generated.");
                    break;
                case 4:
                    view.displayMessage(account.printDetails());
                    break;
                case 0:
                    view.displayMessage("Thank you for using the system.");
                    break;
                default:
                    view.displayMessage("Invalid option.");
                    break;
            }
        } while (option != 0);
    }
}
