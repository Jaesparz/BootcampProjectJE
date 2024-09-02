package View;

import Model.InputValidator;
import Model.NotANumberException;

import java.util.Scanner;

public class MenuView {
    Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void FirstMenu() {

        System.out.println("\n****Crypto Exchange System****\n");
        System.out.println("\nWelcome to the First Menu\n");
        System.out.println("1. Register");
        System.out.println("2. Sign in");
        System.out.println("3. Exit\n");
        System.out.println("Please enter your choice: ");
    }
    public int getFirstMenuOption() {
        String userInput = scanner.next();
        int opcion;
        try {
            InputValidator.validateNumberInput(userInput);
            opcion = Integer.parseInt(userInput);
        } catch (NotANumberException e) {
            System.out.println("Error: You have to Enter a Number. Try Again.\n");
            return getFirstMenuOption();
        }
        return opcion;
    }
    public void displayClosingMessage() {
        System.out.println("Closing app, Thank You");
    }
}