package View;

import Model.*;

import java.util.Scanner;

public class LoginMenuView {
    private Scanner scanner;

    public LoginMenuView(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void loginMenuView() {
        System.out.println("\n\nCurrent Bitcoin Price: "+ Bitcoin.getBitcoinPrice()+"$");
        System.out.println("Current Ethereum Price: "+ Ethereum.getEthereumPrice()+"$\n");

        System.out.println("1. Deposit Money");
        System.out.println("2. Check Wallet");
        System.out.println("3. Buy Cryptocurrencies from the Exchange");
        System.out.println("4. Place purchase Order");
        System.out.println("5. Place sales Order");
        System.out.println("6. View Transactions History");
        System.out.println("7. Log out\n");


    }

    public String getEmailInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                InputValidator.validateWordInput(input);
                return input;
            } catch (NotAWordException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getPasswordInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                InputValidator.validateWordInput(input);
                return input;
            } catch (NotAWordException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getOptionInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.next();
            try {
                InputValidator.validateNumberInput(input);
                return Integer.parseInt(input);
            } catch (NotANumberException e) {
                System.out.println("Error: You have to Enter a Number. Try Again.\n");
            }
        }
    }

    public void showError(String message) {
        System.out.println("ERROR: " + message);
    }

    public void showSuccessMessage(String message) {
        System.out.println(message);
    }

    public void showLogoutMessage() {
        System.out.println("Logging out.......");
    }
    public void showContinueMessage(){
        System.out.println("\nPRESS ENTER TO CONTINUE TO MENU...");
    }
}
