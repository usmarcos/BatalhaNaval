package models;

import enumeradores.Jogador;
import enumeradores.Marcacoes;
import process.JogadaHumano;
import utils.ConversorCharInt;
import java.util.Random;

public class Tabuleiro {
    private final String reset = "\u001B[0m";
    private final String cor_amarela = "\u001B[33m";
    private final String cor_azul = "\u001B[34m";
    private final String cor_roxa = "\u001B[35m";
    private final String cor_vermelho = "\u001B[31m";
    private final String cor_ciano = "\u001B[36m";
    private final String cor_verde = "\u001B[32m";
    private final String separador = "\n------------------------------------------------------------------";
    private final String guia_superior = "     |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | ";
    private final String titulo = "                         JOGADOR ";
    private int tamLinha = 10;
    private int tamColuna = 10;
    public int quantidadeNavios = 10;
    protected char[][] tabuleiro = new char[tamLinha][tamColuna];

    /**
     * Recebe o tamanho da linha e da coluna para criação de um novo tabuleiro
     */
    public Tabuleiro() {
            }

    public void preencherNaviosRandom() {
        Random random = new Random();
        int linhaRandom, colunaRandom;
        for (int i = 0; i < quantidadeNavios; i++) {
            //a cada passada gera uma posição aleatória para preencher uma coordenada na matriz
            linhaRandom = random.nextInt(9);
            colunaRandom = random.nextInt(9);
            if (tabuleiro[linhaRandom][colunaRandom] == Character.MIN_VALUE) {
                tabuleiro[linhaRandom][colunaRandom] = Marcacoes.NAVIO_POSICIONADO.getMarcacao();
            } else {
                i--;
            }
        }
    }

    public void preencherNaviosManualmente() {
        System.out.println("Este será o seu tabuleiro. Digite a posição dos navios:");
        int linha, coluna;
        for (int k = 0; k < quantidadeNavios; k++) {
            toString(Jogador.JOGADOR_HUMANO.getJogador());
            linha = ConversorCharInt.converter(JogadaHumano.getLinha());
            coluna = JogadaHumano.getColuna();
        if (tabuleiro[linha][coluna] == Character.MIN_VALUE) {
            tabuleiro[linha][coluna] = Marcacoes.NAVIO_POSICIONADO.getMarcacao();
        } else {
            k--;
        }
    }
}

     /**
     * E validar as jogadas passando o tabuleiro do inimmigo.
     * Se tiver uma posição já jogada anteriormente vai retornar exceção
     */
    public void setJogada(int linha, int coluna, Tabuleiro inimigo) {

        //valida se jogada já foi feita e se tiver sido vai retornar uma exceção
        if (tabuleiro[linha][coluna] == Marcacoes.TIRO_CERTEIRO.getMarcacao()
                || tabuleiro[linha][coluna] == Marcacoes.TIRO_AGUA.getMarcacao()
                || tabuleiro[linha][coluna] == Marcacoes.TIRO_NAVIO_POSICIONADO.getMarcacao()
                || tabuleiro[linha][coluna] == Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao()) {
            throw new RuntimeException();
        }
        //enviando linha primeiro e depois coluna, pois é assim que uma matriz funciona, primeiro linha e depois coluna.
        validaTiro(linha, coluna, inimigo);
    }

    /**
     * Atirar: (tiro certeiro, água, certeiro com navio posicionado e tiro na água com navio posicionado)
     */
    private void validaTiro(int posicaoLinha, int posicaoColuna, Tabuleiro inimigo) {
        //validações dos tiros e preenchimento do campo na posição
        if (inimigo.tabuleiro[posicaoLinha][posicaoColuna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
            //se no tiro tiver um navio posicionado ele verifica se tem um navio posicionado nesta posição no tabuleiro do inimigo com relação ao do atual
            if (inimigo.tabuleiro[posicaoLinha][posicaoColuna] == tabuleiro[posicaoLinha][posicaoColuna]) {
                //se tiver o mesmo preenchimento ele armazena marcação correspondente
                tabuleiro[posicaoLinha][posicaoColuna] = Marcacoes.TIRO_NAVIO_POSICIONADO.getMarcacao();
            } else {
                //se não tiver ele armazena o tiro
                tabuleiro[posicaoLinha][posicaoColuna] = Marcacoes.TIRO_CERTEIRO.getMarcacao();
            }
            //nesse caso se o jogador der um tiro ele verifica se no tabuleiro inimigo foi tiro na água
        } else if (inimigo.tabuleiro[posicaoLinha][posicaoColuna] == Character.MIN_VALUE) {
            //se no tabuleiro do jogador atual tiver um navio posicionado ele coloca o n minúsculo
            if (tabuleiro[posicaoLinha][posicaoColuna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
                tabuleiro[posicaoLinha][posicaoColuna] = Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao();
            } else {
                //se não tiver navio posicionado vira tiro na água
                tabuleiro[posicaoLinha][posicaoColuna] = Marcacoes.TIRO_AGUA.getMarcacao();
            }
        }
    }
    /**
     * Imprime o tabuleiro em tela e deve ser enviado o enum do jogador correspondente ao objeto
     */
    public void toString(String jogador) {
        System.out.println(separador);
        System.out.print(cor_roxa + titulo + jogador + reset);
        System.out.println(separador);
        System.out.print(cor_azul + guia_superior + reset);
        System.out.println(separador);
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            switch (linha) {
                case 0:
                    System.out.print(cor_azul + "  A  " + reset);
                    break;
                case 1:
                    System.out.print(cor_azul + "  B  " + reset);
                    break;
                case 2:
                    System.out.print(cor_azul + "  C  " + reset);
                    break;
                case 3:
                    System.out.print(cor_azul + "  D  " + reset);
                    break;
                case 4:
                    System.out.print(cor_azul + "  E  " + reset);
                    break;
                case 5:
                    System.out.print(cor_azul + "  F  " + reset);
                    break;
                case 6:
                    System.out.print(cor_azul + "  G  " + reset);
                    break;
                case 7:
                    System.out.print(cor_azul + "  H  " + reset);
                    break;
                case 8:
                    System.out.print(cor_azul + "  I  " + reset);
                    break;
                case 9:
                    System.out.print(cor_azul + "  J  " + reset);
                    break;
            }
            System.out.print("| ");
            for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
                if (tabuleiro[linha][coluna] == Character.MIN_VALUE) {
                    System.out.print("   ");
                } else if (tabuleiro[linha][coluna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
                    System.out.print(cor_amarela + " " + tabuleiro[linha][coluna] + " " + reset);
                } else if (tabuleiro[linha][coluna] == Marcacoes.TIRO_CERTEIRO.getMarcacao()) {
                    System.out.print(cor_vermelho + " " + tabuleiro[linha][coluna] + " " + reset);
                } else if (tabuleiro[linha][coluna] == Marcacoes.TIRO_AGUA.getMarcacao()) {
                    System.out.print(cor_ciano + " " + tabuleiro[linha][coluna] + " " + reset);
                } else if (tabuleiro[linha][coluna] == Marcacoes.TIRO_NAVIO_POSICIONADO.getMarcacao()) {
                    System.out.print(cor_vermelho + " " + tabuleiro[linha][coluna] + " " + reset);
                } else if (tabuleiro[linha][coluna] == Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao()) {
                    System.out.print(cor_verde + " " + tabuleiro[linha][coluna] + " " + reset);
                } else {
                    System.out.print(" " + tabuleiro[linha][coluna] + " ");
                }
                System.out.print(" | ");
            }
            System.out.println(separador);
        }
    }
}
