package View;

import java.util.Scanner;

public class ViewRegistration {
    public ViewRegistration() {
    }

    public void mostrarRegistro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese un correo electrónico: ");
        String correo = scanner.next();
        System.out.print("Ingrese una contraseña: ");
        String contraseña = scanner.next();
    }
}