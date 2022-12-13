package models.Jogador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogadaHumano {
    /**
     * obtém o char com o valor da posição na horizontal
     */
    public static char getLinha() {
        char linha = Character.MIN_VALUE;
        boolean controle = true;
        System.out.print("Informe a linha: ");
        while (controle) {
            //tpUpperCase converte o caracter digitado para maiúsculo sempre.
            linha = new Scanner(System.in).next().toUpperCase().charAt(0);
            // !falta implementar se caso seja digitado letras repetidas
            if (linha == 'A' || linha == 'B' || linha == 'C' || linha == 'D' || linha == 'E' || linha == 'F' || linha == 'G' || linha == 'H' || linha == 'I' || linha == 'J') {
                controle = false;
            } else {
                System.out.print("Digite um valor de linha válido (A, B, C, D, E, F, G, H ou I: ");
            }
        }
        return linha;
    }

    /**
     * obtém o char com o valor da posição na vertical
     */
    public static int getColuna() {
        int coluna = 0;
        boolean controle = true;
        System.out.print("Informe a coluna: ");
        while (controle){
            //verifica se foi número digitado
            try{
                coluna = new Scanner(System.in).nextInt();
            }catch (InputMismatchException e){
                System.out.print("Digite um valor de coluna válido (0, 1, 2, 3, 4, 5, 6, 7, 8, 9: ");
            }
            //verifica se foi um dos números da coluna
            if (coluna == 0 || coluna == 1 || coluna == 2 || coluna == 3 || coluna == 4 || coluna == 5 || coluna == 6 || coluna == 7 || coluna == 8 || coluna == 9) {
                controle = false;
            } else {
                System.out.print("Digite um valor de coluna válido (0, 1, 2, 3, 4, 5, 6, 7, 8, 9: ");
            }
        }
        return coluna;
    }
}
