package View;

import Model.InputValidator;
import Model.NotAWordException;

import java.util.Scanner;

public class RegistrationView {
    private Scanner scanner;

    public RegistrationView(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public String getNameInput(String prompt) {
        String userInput;
        while (true) {
            System.out.println(prompt);
            userInput = scanner.next();
            try {
                InputValidator.validateWordInput(userInput);
                scanner.nextLine(); // Consume the rest of the line
                return userInput;
            } catch (NotAWordException e) {
                System.out.println("Invalid name: " + e.getMessage());
                scanner.nextLine(); // Consume the rest of the line
            }
        }
    }

    public String getEmailInput(String prompt) {
        String userInput;
        while (true) {
            System.out.println(prompt);
            userInput = scanner.next();
            try {
                InputValidator.validateWordInput(userInput);
                scanner.nextLine(); // Consume the rest of the line
                return userInput;
            } catch (NotAWordException e) {
                System.out.println("Invalid email: " + e.getMessage());
                scanner.nextLine(); // Consume the rest of the line
            }
        }
    }

    public String getPasswordInput(String prompt) {
        String userInput;
        while (true) {
            System.out.println(prompt);
            userInput = scanner.next();
            try {
                InputValidator.validateWordInput(userInput);
                scanner.nextLine(); // Consume the rest of the line
                return userInput;
            } catch (NotAWordException e) {
                System.out.println("Invalid password: " + e.getMessage());
                scanner.nextLine(); // Consume the rest of the line
            }
        }
    }

    public void showSuccessMessage(String message) {
        System.out.println(message);
    }
}