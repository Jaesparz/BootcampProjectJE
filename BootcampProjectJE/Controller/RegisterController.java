package Controller;


import Model.InputValidator;
import Model.NotAWordException;
import Model.User;
import View.RegistrationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterController {
    private Scanner scanner;
    private static ArrayList<User> users;

    public RegisterController(Scanner scanner) {
        this.scanner = scanner;
        this.users = new ArrayList<User>();
    }

    public void registerUser() {
        RegistrationView view = new RegistrationView(scanner);
        String name = view.getNameInput("Enter your name: ");
        String email = view.getEmailInput("Enter your email: ");
        String password = view.getPasswordInput("Enter your password: ");

        String username = generateRandomUsername(name);
        User newUser = new User(name, email, password, username);
        users.add(newUser);
        view.showSuccessMessage("Registration successful! Your username is: " + username);
    }

    private String generateRandomUsername(String name) {
        String[] words = name.split(" ");
        String username = words[0].toLowerCase();
        int randomNum = (int)(Math.random() * 1000.0);
        username = username + randomNum;
        return username;
    }
    public  List<User> getRegisteredUsers() {
        return users;
    }
}

