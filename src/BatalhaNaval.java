import enumeradores.Jogador;
import enumeradores.Marcacoes;
import models.Jogador.JogadaHumano;
import models.Jogador.JogadaMaquina;
import models.Tabuleiro;
import utils.LeitorTeclado;

import static models.Jogador.JogadaHumano.getColuna;
import static models.Jogador.JogadaHumano.getLinha;

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
         * 2 - Falta tratar as excessões caso digitado mais de uma letra ou mais de um número.
         * 3 - Falta criar a lógia que dirá quem é o vencedor
         * 4 - Lembrar que no final do jogo deve imprimir o vencedor e os dois tabuleiros (por isso já criei o envio do Enum
         * para informar qual o jogador do objeto
         */

        /**
         * Sempre que for enviar uma jogada envie também na chamada o tabuleiro do objeto do inimigo, seja
         * o humano ou computador para ele poder fazer as devidas comparações
         */

//        // teste
//        Tabuleiro humano = new Tabuleiro();
//        Tabuleiro computador = new Tabuleiro();
//
//        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
//        computador.toString(Jogador.JOGADOR_MAQUINA.getJogador());
//
//        System.out.println("Tiro");
//        humano.setJogada(JogadaHumano.getLinha(), JogadaHumano.getColuna(), computador.getTabuleuiro());
//        //pode imprimir direto ou alterar a classe set jogada para imprimir sempre depois da última jogada
//        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
//        computador.setJogada(JogadaMaquina.setLinha(), JogadaMaquina.setColuna(), humano.getTabuleuiro());
//        computador.toString(Jogador.JOGADOR_MAQUINA.getJogador());

        boolean ligado = true;
        menu();
        boolean loop = true;
        int opcao = LeitorTeclado.getNumero("Digite uma das opções: ");
        switch (opcao){
            case 0:
                System.out.println("O programa será finalizado.");
                ligado = false;
                break;
            case 1:
                Tabuleiro computador1 = new Tabuleiro();
                Tabuleiro humano1 = new Tabuleiro();
                System.out.println("Este será o seu tabuleiro. Digite a posição dos navios:");
                humano1.toString(Jogador.JOGADOR_HUMANO.getJogador());
                humano1.preencherNaviosManualmente();
                loop = true;
                while (loop) {
                    //imprimir os dois tabuleiros (o máquina apenas para teste, depois será removido)
                    humano1.toString(Jogador.JOGADOR_HUMANO.getJogador());
                    computador1.toString(Jogador.JOGADOR_MAQUINA.getJogador());
                    //Jogada humano
                    jogadaHumano(humano1, computador1);
                    jogadaMaquina(computador1,humano1);
                }
                break;
            case 2:
                Tabuleiro humano = new Tabuleiro();
                humano.preencherNaviosTabuleiro();
                Tabuleiro computador = new Tabuleiro();
                System.out.println("Este será o seu tabuleiro");
                loop = true;
                while (loop) {
                    //imprimir os dois tabuleiros (o máquina apenas para teste, depois será removido)
                    humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
                    computador.toString(Jogador.JOGADOR_MAQUINA.getJogador());
                    //Jogada humano
                    jogadaHumano(humano, computador);
                    jogadaMaquina(computador,humano);
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
    private static void jogadaHumano(Tabuleiro jogador, Tabuleiro inimigo){
        //try, pois se já tiver preenchido a jogada vai retornar exceção. Se retornar vai pedir nova jogada (MELHORAR ESSA LÓGICA)
        try {
            jogador.setJogada(getLinha(), JogadaHumano.getColuna(), inimigo);
        } catch (Exception e) {
            System.out.println("Posição já jogada anteriormente, insira uma nova posição");
            jogadaHumano(jogador, inimigo);
        }
    }    private static void jogadaMaquina(Tabuleiro jogador, Tabuleiro inimigo){
        //try, pois se já tiver preenchido a jogada vai retornar exceção. Se retornar vai pedir nova jogada até mesmo pra máquina (MELHORAR ESSA LÓGICA)
        try {
            jogador.setJogada(JogadaMaquina.setLinha(), JogadaMaquina.setColuna(), inimigo);
        } catch (Exception e) {
            jogadaHumano(jogador, inimigo);
        }
    }
}