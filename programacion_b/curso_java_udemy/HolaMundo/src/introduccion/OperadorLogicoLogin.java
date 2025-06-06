package introduccion;

import java.util.Scanner;

public class OperadorLogicoLogin {
    public static void main(String[] args) {
        /*String[] usuarios = new String[3];
        String[] passwords = new String[3];
        usuarios[0] = "Javi";
        passwords[0] = "1234";

        usuarios[1] = "Aitor";
        passwords[1] = "4321";

        usuarios[2] = "Miguel";
        passwords[2] = "1243";*/
        String[] usuarios = { "Javi", "Aitor", "Miguel" };
        String[] passwords = { "1234", "4321", "1243" };

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario: ");
        String userInput = sc.nextLine();
        System.out.println("Introduce la contraseña: ");
        String passInput = sc.nextLine();

        boolean loginSuccess = false;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equals(userInput) && passwords[i].equals(passInput)) {
                loginSuccess = true;
                break;
            }
        }

        if (loginSuccess)
            System.out.println("Bienvenido ".concat(userInput).concat("!"));
        else
            System.out.println("El usuario / contraseña no son correctos.");
    }
}
