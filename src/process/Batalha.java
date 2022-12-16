package process;

import enumeradores.Jogador;
import models.Tabuleiro;
import utils.LeitorTeclado;
import utils.MenuInicial;

import static process.JogadaHumano.getColuna;
import static process.JogadaHumano.getLinha;

public class Batalha {

    public static void executar () {
        MenuInicial.menu();
        boolean loop = true;
        boolean continua = true;
        do {
            int opcao = LeitorTeclado.getNumero("Digite uma das opções: ");
            switch (opcao) {
                case 0:
                    continua = false;
                    System.out.println("O programa será finalizado.");
                    break;
                case 1:
                    Tabuleiro computador1 = new Tabuleiro();
                    computador1.preencherNaviosRandom();
                    Tabuleiro humano1 = new Tabuleiro();
                    humano1.toString(Jogador.JOGADOR_HUMANO.getJogador());
                    humano1.preencherNaviosManualmente();

                    loop = true;
                    while (loop) {
                        //imprimir os dois tabuleiros (o máquina apenas para teste, depois será removido)
                        humano1.toString(Jogador.JOGADOR_HUMANO.getJogador());
                        computador1.toString(Jogador.JOGADOR_MAQUINA.getJogador());
                        //Jogada humano
                        jogadaHumano(humano1, computador1);
                        jogadaMaquina(computador1, humano1);
                    }
                    break;
                case 2:
                    Tabuleiro humano = new Tabuleiro();
                    humano.preencherNaviosRandom();
                    Tabuleiro computador = new Tabuleiro();
                    computador.preencherNaviosRandom();
                    System.out.println("Este será o seu tabuleiro");
                    loop = true;
                    while (loop) {
                        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
                        //Jogada humano
                        jogadaHumano(humano, computador);
                        jogadaMaquina(computador, humano);

                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continua = true;
                    break;


            }
        } while (continua);
    }


    private static void jogadaHumano(Tabuleiro jogador, Tabuleiro inimigo){
        //try, pois se já tiver preenchido a jogada vai retornar exceção. Se retornar vai pedir nova jogada (MELHORAR ESSA LÓGICA)
        try {
            jogador.setJogada(getLinha(), getColuna(), inimigo);
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
