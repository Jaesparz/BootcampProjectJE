package Controller;

import Model.InputValidator;
import Model.NotANumberException;
import Model.NotAWordException;
import Model.User;
import View.LoginMenuView;

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

                        LoginMenuView loginMenuView = new LoginMenuView();
                        Scanner scanner = new Scanner(System.in);
                        DepositMoneyController depositMoneyController = new DepositMoneyController(scanner);
                        ControllerCheckWallet controllerCheckWallet = new ControllerCheckWallet();
                        boolean salir = false;

                        while(!salir) {
                            loginMenuView.loginMenuView();
                            String userInput = scanner.next();

                            int opcion;
                            try {
                                InputValidator.validateNumberInput(userInput);
                                opcion = Integer.parseInt(userInput);
                            } catch (NotANumberException var10) {
                                System.out.println("Error: You have to Enter a Number. Try Again.\n");
                                continue;
                            }

                            switch (opcion) {
                                case 1:
                                    depositMoneyController.save();

                                    break;
                                case 2:
                                    controllerCheckWallet.checkWallet();


                                    break;
                                case 3:
                                    System.out.println("Not Implemented yet");
                                    break;
                                case 4:
                                    System.out.println("Not Implemented yet");
                                    break;
                                case 5:
                                    System.out.println("Not Implemented yet");
                                    break;
                                case 6:
                                    System.out.println("Not Implemented yet");


                            }

                            scanner.nextLine();
                            continue;
                        }
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
