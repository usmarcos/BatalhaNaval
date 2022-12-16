package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorTeclado {
    public static int getNumero(String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(frase);
        try {
            return entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida.");
            return getNumero(frase);
        }
    }

    public static int getString(String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(frase);
        try {
            return entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida.");
            return getNumero(frase);
        }
    }

}
