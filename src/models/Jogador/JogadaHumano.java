package models.Jogador;

import java.util.Scanner;

public class JogadaHumano {
    /**
     * obtém o char com o valor da posição na horizontal
     */
    public static char getLinha() {
        System.out.print("Informe a linha: ");
        char linha = new Scanner(System.in).next().toUpperCase().charAt(0);
        return linha;
    }

    /**
     * obtém o char com o valor da posição na vertical
     */
    public static int getColuna() {
        System.out.print("Informe a coluna: ");
        int coluna = new Scanner(System.in).nextInt();
        return coluna;
    }
}
