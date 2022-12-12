import models.Jogador.JogadaHumano;
import models.Jogador.JogadaMaquina;
import models.Tabuleiro;

public class BatalhaNaval {
    public static void main(String[] args) {
        Tabuleiro humano = new Tabuleiro();
        Tabuleiro computador = new Tabuleiro();

        humano.printTabuleiro();

        System.out.println("Tiro");
        humano.setJogada(JogadaHumano.getLinha(), JogadaHumano.getColuna());
        humano.printTabuleiro();
        computador.setJogada(JogadaMaquina.setLinha(), JogadaMaquina.setColuna());
        computador.printTabuleiro();



    }
}