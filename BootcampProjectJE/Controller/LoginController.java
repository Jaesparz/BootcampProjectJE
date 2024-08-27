package Controller;

import Model.InputValidator;
import Model.NotAWordException;
import Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController {
    public static Scanner scanner;
    Comprador comprador = new Comprador();
    RegisterController registerController = new RegisterController(LoginController.scanner);
    List<User> registeredUsers = registerController.getRegisteredUsers();

    public LoginController(Scanner scanner) {
        this.scanner = scanner;

    }

    public void login() {
        while (true) {
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            try {
                InputValidator.validateWordInput(email);
            } catch (NotAWordException e) {
                System.out.println(e.getMessage());
                continue;
            }

            boolean emailExists = false;
            for (User user : registeredUsers) {
                if (user.getMail().equals(email)) {
                    emailExists = true;
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    try {
                        InputValidator.validateWordInput(password);
                    } catch (NotAWordException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    if (user.getPassword().equals(password)) {
                        System.out.println("Login successful!");

                        comprador.holamundo();
                        return;
                    } else {
                        System.out.println("ERROR");
                        System.out.println("Please try again!");
                        continue;
                    }
                }
            }
            if (!emailExists) {
                System.out.println("Email does not exist");
                System.out.println("ERROR");
                System.out.println("Please try again!");
                continue;
            }
        }
    }
}
