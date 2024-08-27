import Controller.RegisterController;
import Model.InputValidator;
import Model.NotANumberException;
import View.ViewMenu;
import View.ViewRegistration;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public Main() {
    }

    public static void main(String[] args) {
        InputValidator validator = new InputValidator();
        new ViewRegistration();
        RegisterController registerController = new RegisterController(Main.scanner);
        ViewMenu menu = new ViewMenu();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while(!salir) {
            menu.FirstMenu();
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
                    registerController.registerUser();
                    break;
                case 2:
                    System.out.println("Not implemented yet");
                default:
                    salir = true;
                    System.out.println("Closing app, Thank You");
            }

            scanner.nextLine();
        }

    }

    static {
        scanner = new Scanner(System.in);
    }
}
