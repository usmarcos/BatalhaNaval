package process;

import enumeradores.Jogador;
import models.Tabuleiro;
import utils.LeitorTeclado;
import utils.MenuInicial;

import static process.VezDoHumano.getColuna;
import static process.VezDoHumano.getLinha;

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
                        //jogadaHumano(humano1, computador1);
                        //jogadaMaquina(computador1, humano1);
                    }
                    break;
                case 2:
                    int linha, coluna, pontosHumano = 0, pontosMaquina = 0;
                    Tabuleiro humano = new Tabuleiro();
                    humano.preencherNaviosRandom();
                    Tabuleiro computador = new Tabuleiro();
                    computador.preencherNaviosRandom();
                    System.out.println("Este será o seu tabuleiro");
                    loop = true;
                    while (loop) {

                        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());

                        //Jogada humano
                        linha = VezDoHumano.getLinha();
                        coluna = VezDoHumano.getColuna();
                        pontosHumano += Jogada(int linha; int coluna; char[][] computador);

                        //Jogada máquina
                        linha = VezDaMaquina.setLinha();
                        coluna = VezDaMaquina.setColuna();
                        pontosMaquina += Jogada(int linha; int coluna; char[][] humano);

                        //jogadaHumano(humano, computador);
                        //jogadaMaquina(computador, humano);

                        if (pontosMaquina == 10) {
                            loop = false;
                            System.out.println("Máquina Venceu!");
                        }
                        if (pontosHumano == 10) {
                            loop = false;
                            System.out.println("Máquina Venceu!");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continua = true;
                    break;
            }
        } while (continua);
    }


}
