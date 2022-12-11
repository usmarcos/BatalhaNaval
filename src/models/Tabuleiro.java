package models;

import java.util.Random;

public class Tabuleiro {
    final String SEPARADOR = "\n------------------------------------------------------------";
    private int tamLinha = 10;
    private int tamColuna = 10;
    private int quantidadeNavios = 8;
    private char[][] tabuleiro = new char[tamLinha][tamColuna];


    /**
     * Recebe o tamanho da linha e da coluna para criação de um novo tabuleiro
     */
    public Tabuleiro() {
        preencherNaviosTabuleiro();
    }

    /**
     * Preenche os navios randomicamente para iniciar a partida
     */
    private void preencherNaviosTabuleiro() {
        Random random = new Random();
        int linhaRandom, colunaRandom;
        char navio = 'N';
        for (int i = 0; i < quantidadeNavios; i++) {
            //a cada passada gera um uma posição aleatória nota
            linhaRandom = random.nextInt(9);
            colunaRandom = random.nextInt(9);

            if (tabuleiro[linhaRandom][colunaRandom] == Character.MIN_VALUE) {
                tabuleiro[linhaRandom][colunaRandom] = navio;
            } else {
                i--;
            }
        }
    }

    public void printTabuleiro() {
        System.out.println(SEPARADOR);
        for (int linha = 0; linha < tamLinha; linha++) {
            System.out.print("|");
            for (int coluna = 0; coluna < tamColuna; coluna++) {
                if (tabuleiro[linha][coluna] == Character.MIN_VALUE) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + tabuleiro[linha][coluna] + " ");
                }
                System.out.print(" | ");
            }
            System.out.println(SEPARADOR);
        }
    }
}
