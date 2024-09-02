import Controller.LoginController;
import Controller.RegisterController;
import Model.InputValidator;
import View.MenuView;
import java.util.Scanner;

public class CrytoExchangeSystem {
    public static Scanner scanner = new Scanner(System.in);

    public CrytoExchangeSystem() {
    }

    public static void main(String[] args) {

        InputValidator validator = new InputValidator();
        MenuView menu = new MenuView(scanner);
        RegisterController registerController = new RegisterController(scanner);
        LoginController loginController = new LoginController(scanner);

        boolean salir = false;

        while(!salir) {
            menu.FirstMenu();
            int option = menu.getFirstMenuOption();
            switch (option) {
                case 1:
                    registerController.registerUser();

                    break;
                case 2:
                    loginController.login();
                    salir = true;
                    break;
                case 3:
                    menu.displayClosingMessage();
                    salir = true;
            }

        }
    }

}
