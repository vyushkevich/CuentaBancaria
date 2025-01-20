package factoriaf5.cuentabancaria.View;

import java.util.Scanner;

public class BankView {
    private Scanner scanner;

    public BankView() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Generate Monthly Statement");
        System.out.println("4. Print Account Details");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public float requestAmount(String message) {
        System.out.print(message);
        return scanner.nextFloat();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
