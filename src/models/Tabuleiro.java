package models;

import enumeradores.Jogador;
import enumeradores.Marcacoes;
import process.VezDoHumano;
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
    public char[][] tabuleiro = new char[tamLinha][tamColuna];

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
            linha = ConversorCharInt.converter(VezDoHumano.getLinha());
            coluna = VezDoHumano.getColuna();
        if (tabuleiro[linha][coluna] == Character.MIN_VALUE) {
            tabuleiro[linha][coluna] = Marcacoes.NAVIO_POSICIONADO.getMarcacao();
        } else {
            k--;
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
