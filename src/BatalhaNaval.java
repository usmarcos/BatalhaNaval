import enumeradores.Jogador;
import models.Jogador.JogadaHumano;
import models.Jogador.JogadaMaquina;
import models.Tabuleiro;

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
         * 2 - Falta lógica para identificar se foi tiro na água com navio posicionado (n) (não entendi como funcionará ainda)
         * 3 - Falta tratar as excessões caso digitado mais de uma letra ou mais de um número.
         * 4 - Falta criar a lógia que dirá quem é o vencedor
         * 5 - Lembrar que no final do jogo deve imprimir o vencedor e os dois tabuleiros (por isso já criei o envio do Enum
         * para informar qual o jogador do objeto
         */

        // teste
        Tabuleiro humano = new Tabuleiro();
        Tabuleiro computador = new Tabuleiro();

        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());

        System.out.println("Tiro");
        humano.setJogada(JogadaHumano.getLinha(), JogadaHumano.getColuna());
        //pode imprimir direto ou alterar a classe set jogada para imprimir sempre depois da ultima jogada
        humano.toString(Jogador.JOGADOR_HUMANO.getJogador());
        computador.setJogada(JogadaMaquina.setLinha(), JogadaMaquina.setColuna());
        computador.toString(Jogador.JOGADOR_MAQUINA.getJogador());


    }
}