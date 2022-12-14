import enumeradores.Jogador;
import models.Jogador.JogadaHumano;
import models.Jogador.JogadaMaquina;
import models.Tabuleiro;
import utils.LeitorTeclado;

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
        menu();
    }

    private static void menu() {
        System.out.println("\nEscolha uma das opções abaixo:\n");
        System.out.println("0 - Para Encerrar.");
        System.out.println("1 - Iniciar um novo jogo escolhendo as posições dos navios.");
        System.out.println("2 - Iniciar um novo jogo com as posições geradas automaticamente.");

        int opcao = LeitorTeclado.getNumero("\nDigite uma das opções: ");
        switch (opcao) {
            case 0:
                System.out.println("\nO programa será finalizado.");
                System.exit(1);
                break;
            case 1:
                novoJogo('M');
                break;
            case 2:
                novoJogo('A');
                break;
            default:
                System.out.println("Opação inválida. Tente novamente.");
                break;
        }
        menu();
    }

    /**
     * Realiza um novo jogo recebendo a descisão do jogador (se deseja que gere de forma automática ou manual
     */
    private static void novoJogo(char decisaoJogador) {
        int cont = 0;
        Tabuleiro humano = new Tabuleiro(decisaoJogador);
        Tabuleiro maquina = new Tabuleiro('A');
        System.out.println("\n\n------------------------ PARTIDA INICIADA ------------------------");
        while (true) {
            //imprimir os dois tabuleiros (o máquina apenas para teste, depois será removido)
            humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
            maquina.toString(Jogador.JOGADOR_MAQUINA.getJogador());
            //Jogada humano
            System.out.println("Jogada de número: " + ++cont);
            JogadaHumano.jogadaHumano(humano, maquina);
            //verifica se o humano venceu, se sim retorna false e finaliza o loop
            if (humano.verificaGanhador(maquina)) {
                System.out.println("\nNessa partida houveram "+ cont +" jogadas!");
                break;
            }
            System.out.println("O computador fez a jogada de número: " + ++cont);
            JogadaMaquina.jogadaMaquina(maquina, humano);
            //verifica se a máquina venceu, se sim retorna false e finaliza o loop
            if (maquina.verificaGanhador(humano)) {
                System.out.println("\nNessa partida houveram "+ cont +" jogadas!");
                break;
            }
        }
        System.out.println("\n----------------------- TABULEIROS FINAIS ------------------------");
        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
        maquina.toString(Jogador.JOGADOR_MAQUINA.getJogador());
    }
}