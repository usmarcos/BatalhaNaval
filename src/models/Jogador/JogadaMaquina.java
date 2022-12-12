package models.Jogador;

import models.Tabuleiro;

import java.util.Random;

public class JogadaMaquina extends Tabuleiro {

    /**
     * obtem o char com o valor da posição na horizontal
     */
    public static char setLinha() {
        Random random = new Random();
        //vai gerar uma letra randomicamente que corresponde de 0 a 9 ao alfabeto (0 = A, 1 = B...).
        char linha = (char) (random.nextInt(9) + 'A');
        return linha;
    }


    /**
     * obtem o char com o valor da posição na vertical
     */
    public static int setColuna() {
        Random random = new Random();
        int coluna = random.nextInt(9);
        return coluna;
    }

}
