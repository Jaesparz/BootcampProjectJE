package Controller;

import Model.*;
import View.LoginMenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController {
    public static Scanner scanner;
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
                        Wallet wallet = new Wallet();
                        DepositMoneyController depositMoneyController = new DepositMoneyController(scanner);
                        ControllerCheckWallet controllerCheckWallet = new ControllerCheckWallet();
                        PurchaseController purchaseController = new PurchaseController(scanner);
                        SalesController salesController = new SalesController(scanner);

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
                                    purchaseController.placeBuyOrder();

                                    break;
                                case 4:
                                    salesController.placeSellOrder();

                                    break;
                                case 5:
                                    HistoryController.showHistory();


                                    break;
                                case 6:
                                    System.out.println("Logging out...");
                                    return;





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
