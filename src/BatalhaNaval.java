import processos.Batalha;

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
         *
         * 1 - Falta tratar as excessões caso digitado mais de uma letra ou mais de um número.
         * 3 - Falta criar a lógia que dirá quem é o vencedor
         * 4 - Lembrar que no final do jogo deve imprimir o vencedor e os dois tabuleiros (por isso já criei o envio do Enum
         * para informar qual o jogador do objeto
         */

        /**
         * Sempre que for enviar uma jogada envie também na chamada o tabuleiro do objeto do inimigo, seja
         * o humano ou computador para ele poder fazer as devidas comparações
         */

        Batalha.executar();
    }
}