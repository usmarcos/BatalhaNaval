package models.Jogador;

import java.util.Random;

public class JogadaMaquina {

    /**
     * obtém o char com o valor da posição na horizontal
     */
    public static char setLinha() {
        Random random = new Random();
        //vai gerar uma letra randomicamente que corresponde de 0 a 9 ao alfabeto (0 = A, 1 = B...).
        char linha = (char) (random.nextInt(9) + 'A');
        return linha;
    }


    /**
     * obtém o char com o valor da posição na vertical
     */
    public static int setColuna() {
        Random random = new Random();
        int coluna = random.nextInt(9);
        return coluna;
    }

}
