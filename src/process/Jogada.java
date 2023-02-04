package process;

import enumeradores.Marcacoes;
import models.Tabuleiro;

public class Jogada {

    public int setJogada(int linha, int coluna, char [][] inimigo) {
        int contador = 0;

        //valida se jogada já foi feita e se tiver sido vai retornar uma exceção
        if (inimigo[linha][coluna] == Marcacoes.TIRO_CERTEIRO.getMarcacao()
                || inimigo[linha][coluna] == Marcacoes.TIRO_AGUA.getMarcacao()
                || inimigo[linha][coluna] == Marcacoes.TIRO_NAVIO_POSICIONADO.getMarcacao()
                || inimigo[linha][coluna] == Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao()) {
            throw new RuntimeException();
        }

        //validações dos tiros e preenchimento do campo na posição
        if (inimigo[linha][coluna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
            contador++;
            //se no tiro tiver um navio posicionado ele verifica se tem um navio posicionado nesta posição no tabuleiro do inimigo com relação ao do atual
            if (inimigo[linha][coluna] == inimigo[linha][coluna]) {
                //se tiver o mesmo preenchimento ele armazena marcação correspondente
                inimigo[linha][coluna] = Marcacoes.TIRO_NAVIO_POSICIONADO.getMarcacao();
            } else {
                //se não tiver ele armazena o tiro
                inimigo[linha][coluna] = Marcacoes.TIRO_CERTEIRO.getMarcacao();
            }
            //nesse caso se o jogador der um tiro ele verifica se no tabuleiro inimigo foi tiro na água
        } else if (inimigo[linha][coluna] == Character.MIN_VALUE) {
            //se no tabuleiro do jogador atual tiver um navio posicionado ele coloca o n minúsculo
            if (inimigo[linha][coluna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
                inimigo[linha][coluna] = Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao();
            } else {
                //se não tiver navio posicionado vira tiro na água
                inimigo[linha][coluna] = Marcacoes.TIRO_AGUA.getMarcacao();
            }
        }



        return contador;


    }

}
