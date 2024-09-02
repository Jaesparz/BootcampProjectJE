package Controller;

import Model.*;
import View.LoginMenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController {
    public static Scanner scanner;
    RegisterController registerController = new RegisterController(LoginController.scanner);


    public LoginController(Scanner scanner) {
        this.scanner = scanner;

    }

    public void login() {

        List<User> registeredUsers = registerController.getRegisteredUsers();
        LoginMenuView view = new LoginMenuView(scanner);
        while (true) {
            String email = view.getEmailInput("Enter email:");

            boolean emailExists = false;
            for (User user : registeredUsers) {
                if (user.getMail().equals(email)) {
                    emailExists = true;

                    String password = view.getPasswordInput("Enter password:");

                    if (user.getPassword().equals(password)) {
                        System.out.println("Login successful!");

                        Scanner scanner = new Scanner(System.in);
                        DepositMoneyController depositMoneyController = new DepositMoneyController();
                        ControllerCheckWallet controllerCheckWallet = new ControllerCheckWallet();
                        CryptocurrenciesfromExchangeController cryptocurrenciesfromExchangeController = new CryptocurrenciesfromExchangeController(scanner);
                        PurchaseController purchaseController = new PurchaseController(scanner);
                        SalesController salesController = new SalesController(scanner);

                        boolean salir = false;

                        while(!salir) {
                            view.loginMenuView();
                            int opcion = view.getOptionInput("Enter your choice: ");


                            switch (opcion) {
                                case 1:
                                    depositMoneyController.save();
                                    break;
                                case 2:
                                    controllerCheckWallet.checkWallet();

                                    break;
                                case 3:
                                    cryptocurrenciesfromExchangeController.BuyCryptocurrenciesFromExchange();

                                    break;
                                case 4:
                                    purchaseController.placeBuyOrder();
                                    break;
                                case 5:
                                    salesController.placeSellOrder();

                                    break;
                                case 6:
                                    HistoryController.showHistory();

                                    break;

                                case 7:
                                    view.showLogoutMessage();
                                    return;
                            }
                            continue;
                        }
                        return;
                    } else {
                        view.showError("ERROR");
                        view.showError("Please try again");
                        continue;
                    }
                }
            }
            if (!emailExists) {
                view.showError("Email does not exist");
                view.showError("ERROR");
                view.showError("Please try again");
                continue;
            }
        }
    }
}
