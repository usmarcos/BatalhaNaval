import enumeradores.Jogador;
import models.Jogador.JogadaHumano;
import models.Jogador.JogadaMaquina;
import models.Tabuleiro;
import utils.LeitorTeclado;

import java.util.Scanner;

public class BatalhaNaval {
    /**
     * Primeiro deve-se inserir a LINHA preenchendo com LETRAS de A a I
     * Por segundo, deve-se inserir COLUNA preenchendo com números de 0 a 9
     * E depois serão lançadas as jogadas da máquina.
     */
    public static void main(String[] args) {
        System.out.println("▒█▀▀█ ░█▀▀█ ▀▀█▀▀ ░█▀▀█ ▒█░░░ ▒█░▒█ ░█▀▀█   ▒█▄░▒█ ░█▀▀█ ▒█░░▒█ ░█▀▀█ ▒█░░░ ");
        System.out.println("▒█▀▀▄ ▒█▄▄█ ░▒█░░ ▒█▄▄█ ▒█░░░ ▒█▀▀█ ▒█▄▄█   ▒█▒█▒█ ▒█▄▄█ ░▒█▒█░ ▒█▄▄█ ▒█░░░ ");
        System.out.println("▒█▄▄█ ▒█░▒█ ░▒█░░ ▒█░▒█ ▒█▄▄█ ▒█░▒█ ▒█░▒█   ▒█░░▀█ ▒█░▒█ ░░▀▄▀░ ▒█░▒█ ▒█▄▄█ ");

        /**
         * Lista do que falta implementar:
         * 1 - Falta definir como funcionará o menu, se terá sequência e criar o método.
         * 2 - Falta lógica para identificar se foi tiro na água com navio posicionado (n) N pode virar n se no seu
         * tabuleiro tiver um navio seu e na mesma posição tiver um do inimigo. Então se nessa posição tiver um navio inimigo
         * vira X e se for tiro na água vira n.
         * 3 - Falta tratar as excessões caso digitado mais de uma letra ou mais de um número.
         * 4 - Falta criar a lógia que dirá quem é o vencedor
         * 5 - Lembrar que no final do jogo deve imprimir o vencedor e os dois tabuleiros (por isso já criei o envio do Enum
         * para informar qual o jogador do objeto
         */

        // teste
//        Tabuleiro humano = new Tabuleiro();
//        Tabuleiro computador = new Tabuleiro();
//
//        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
//
//        System.out.println("Tiro");
//        humano.setJogada(JogadaHumano.getLinha(), JogadaHumano.getColuna());
//        //pode imprimir direto ou alterar a classe set jogada para imprimir sempre depois da última jogada
//        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
//        computador.setJogada(JogadaMaquina.setLinha(), JogadaMaquina.setColuna());
//        computador.toString(Jogador.JOGADOR_MAQUINA.getJogador());

        boolean ligado = true;
        menu();
        int opcao = LeitorTeclado.getNumero("Digite uma das opções: ");
        switch (opcao){
            case 0:
                System.out.println("O programa será finalizado.");
                ligado = false;
                break;
            case 1:
                //fazer depois
                break;
            case 2:
                Tabuleiro humano = new Tabuleiro();
                Tabuleiro computador = new Tabuleiro();
                System.out.println("Este será o seu tabuleiro");
                boolean loop = true;
                while (loop){
                    humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
                    //apenas para validar as jogadas
                    computador.toString(Jogador.JOGADOR_MAQUINA.getJogador());
                    humano.setJogada(JogadaHumano.getLinha(), JogadaHumano.getColuna(), humano.getTabuleuiro(), computador.getTabuleuiro());
                }

                break;
            default:
                System.out.println("Opação inválida. Tente novamente.");
                break;
        }
    }

    private static void menu(){
        System.out.println("Escolha uma das opções abaixo.");
        System.out.println("0 - Para Encerrar.");
        System.out.println("1 - Iniciar um novo jogo escolhendo as posições dos navios.");
        System.out.println("2 - Iniciar um novo jogo com as posições geradas automaticamente.");
    }
}