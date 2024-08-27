package View;

import java.util.Scanner;

public class ViewMenu {
    Scanner scanner;

    public ViewMenu() {
        this.scanner = new Scanner(System.in);
    }

    public void FirstMenu() {
        System.out.println("Welcome to the First Menu\n");
        System.out.println("1. Register");
        System.out.println("2. Sign in");
        System.out.println("3. Exit\n");
        System.out.println("Please enter your choice: ");
    }
}