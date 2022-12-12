package models;

import java.util.Random;

public class Tabuleiro {
    public static final String RESET = "\u001B[0m";
    public static final String COR_AMARELA = "\u001B[33m";
    public static final String COR_AZUL = "\u001B[34m";
    public static final String COR_ROXA = "\u001B[35m";
    final String SEPARADOR = "\n------------------------------------------------------------------";
    final String GUIA_SUPERIOR = "     |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | ";
    private static int tamLinha = 10;
    private static int tamColuna = 10;
    private int quantidadeNavios = 10;
    protected static char[][] tabuleiro = new char[tamLinha][tamColuna];


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

    public void setJogada(char linha, int coluna) {
        //converte a coluna char para um INT para validar as posições da matriz
        switch (linha) {
            case 'A':
                linha = (char) 0;
                break;
            case 'B':
                linha = (char) 1;
                break;
            case 'C':
                linha = (char) 2;
                break;
            case 'D':
                linha = (char) 3;
                break;
            case 'E':
                linha = (char) 4;
                break;
            case 'F':
                linha = (char) 5;
                break;
            case 'G':
                linha = (char) 6;
                break;
            case 'H':
                linha = (char) 7;
                break;
            case 'I':
                linha = (char) 8;
                break;
            case 'J':
                linha = (char) 9;
                break;
        }
        //enviando linha primeiro e depois coluna, pois é assim que uma matriz funciona, primeiro coluna e depois linha.
        validaTiro(linha, coluna);
    }

    /**
     * Atirar: (tiro certeiro, água, certeiro com navio posicionado e tiro na água com navio posicionado)
     */
    private void validaTiro(int poiscaoLinha, int posicaoColuna) {
        //validações dos tiros e preenchimento do campo na posição
        if (tabuleiro[poiscaoLinha][posicaoColuna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
            tabuleiro[poiscaoLinha][posicaoColuna] = Marcacoes.TIRO_CERTEIRO.getMarcacao();
        } else if (tabuleiro[poiscaoLinha][posicaoColuna] == Marcacoes.TIRO_NAVIO_POSICIONADO.getMarcacao()) {
            tabuleiro[poiscaoLinha][posicaoColuna] = Marcacoes.NAVIO_POSICIONADO.getMarcacao();
        } else if (tabuleiro[poiscaoLinha][posicaoColuna] == Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao()) {
            tabuleiro[poiscaoLinha][posicaoColuna] = Marcacoes.TIRO_AGUA_NAVIO_POSICIONADO.getMarcacao();
        } else {
            //caso não atenda nenhuma acima retorna tiro na água
            tabuleiro[poiscaoLinha][posicaoColuna] = Marcacoes.TIRO_AGUA.getMarcacao();
        }
    }

    /**
     * Imprime o tabuleiro em tela
     */
    public void printTabuleiro() {
        System.out.println(SEPARADOR);
        System.out.print(COR_ROXA + "                            JOGADOR" + RESET);
        System.out.println(SEPARADOR);
        System.out.print(COR_AZUL + GUIA_SUPERIOR + RESET);
        System.out.println(SEPARADOR);
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            switch (linha) {
                case 0:
                    System.out.print(COR_AZUL + "  A  " + RESET);
                    break;
                case 1:
                    System.out.print(COR_AZUL + "  B  " + RESET);
                    break;
                case 2:
                    System.out.print(COR_AZUL + "  C  " + RESET);
                    break;
                case 3:
                    System.out.print(COR_AZUL + "  D  " + RESET);
                    break;
                case 4:
                    System.out.print(COR_AZUL + "  E  " + RESET);
                    break;
                case 5:
                    System.out.print(COR_AZUL + "  F  " + RESET);
                    break;
                case 6:
                    System.out.print(COR_AZUL + "  G  " + RESET);
                    break;
                case 7:
                    System.out.print(COR_AZUL + "  H  " + RESET);
                    break;
                case 8:
                    System.out.print(COR_AZUL + "  I  " + RESET);
                    break;
                case 9:
                    System.out.print(COR_AZUL + "  J  " + RESET);
                    break;
            }
            System.out.print("| ");
            for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
                if (tabuleiro[linha][coluna] == Character.MIN_VALUE) {
                    System.out.print("   ");
                } else if (tabuleiro[linha][coluna] == Marcacoes.NAVIO_POSICIONADO.getMarcacao()) {
                    System.out.print(COR_AMARELA + " " + tabuleiro[linha][coluna] + " " + RESET);
                } else {
                    System.out.print(" " + tabuleiro[linha][coluna] + " ");
                }
                System.out.print(" | ");
            }
            System.out.println(SEPARADOR);
        }
    }
}
