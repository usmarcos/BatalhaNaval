package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class LeitorTeclado {
    public static int getNumero(String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.print(frase);
        try {
            return entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida.");
            return getNumero(frase);
        }
    }
}