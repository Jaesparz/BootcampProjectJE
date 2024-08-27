package Controller;


import Model.InputValidator;
import Model.NotAWordException;
import Model.User;

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
        while(true) {
            System.out.println("Enter your name: ");
            String name = this.scanner.nextLine();

            NotAWordException e;
            try {
                InputValidator.validateWordInput(name);
            } catch (NotAWordException var6) {
                e = var6;
                System.out.println("Invalid name: " + e.getMessage());
                continue;
            }

            String email;
            while(true) {
                System.out.println("Enter your email: ");
                email = this.scanner.nextLine();

                try {
                    InputValidator.validateWordInput(email);
                    break;
                } catch (NotAWordException var8) {
                    e = var8;
                    System.out.println("Invalid email: " + e.getMessage());
                }
            }

            String password;
            while(true) {
                System.out.println("Enter your password: ");
                password = this.scanner.nextLine();

                try {
                    InputValidator.validateWordInput(password);
                    break;
                } catch (NotAWordException var7) {
                    e = var7;
                    System.out.println("Invalid password: " + e.getMessage());
                }
            }

            String username = this.generateRandomUsername(name);
            User newUser = new User(name, email, password, username);
            users.add(newUser);
            System.out.println("Registration successful! Your username is: " + username);
            return;
        }
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

