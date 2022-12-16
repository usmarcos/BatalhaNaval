package models;

import enumeradores.Jogador;

public class Placar {
    static String historico[] = new String[50];

    private static void placar(Jogador vencedor) {
        for (int i = 0; i < historico.length; i++) {
            if (historico[i] == null) {
                historico[i] = vencedor.getJogador();
                break;
            }
        }
    }

    /**
     * Imprime placar recebendo o parâmetro
     */
    public static void imprimePlacar(Jogador vencedor) {
        placar(vencedor);
        System.out.println("\n======================== Placar Atual =============================");
        int contadorHumano = 0, contadorMaquina = 0;
        for (int i = 0; i < historico.length; i++) {
            if (historico[i] == Jogador.JOGADOR_HUMANO.getJogador()) {
                contadorHumano++;
            } else if (historico[i] == Jogador.JOGADOR_MAQUINA.getJogador()){
                contadorMaquina++;
            }
        }
        System.out.println("O jogador humano venceu "+contadorHumano+" vezes.");
        System.out.println("O jogador máquina venceu "+contadorMaquina+" vezes.");
        System.out.println("===================================================================");
    }

    /**
     * Imprime placar sem passar parâmetro
     */
    public static void imprimePlacar() {
        System.out.println("\n======================== Placar Atual =============================");
        int contadorHumano = 0, contadorMaquina = 0;
        for (int i = 0; i < historico.length; i++) {
            if (historico[i] == Jogador.JOGADOR_HUMANO.getJogador()) {
                contadorHumano++;
            } else if (historico[i] == Jogador.JOGADOR_MAQUINA.getJogador()){
                contadorMaquina++;
            }
        }
        System.out.println("O jogador humano venceu "+contadorHumano+" vezes.");
        System.out.println("O jogador máquina venceu "+contadorMaquina+" vezes.");
        System.out.println("===================================================================");
    }
}
