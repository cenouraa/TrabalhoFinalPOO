package jogodavelha;

import armazenamento.GerenciaJogadores;
import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.GerenciaJogadoresArrayList;
import entradados.Console;

/** classe main para funcionamento do jogo */
public class App {
    /**
     * Método principal que inicializa a gerência de jogadores e inicia o jogo.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        GerenciaJogadores gerenciaJogadores = new GerenciaJogadoresArquivo("jogadores.txt"); // ou new GerenciaJogadoresArrayList();
        Jogo jogo = new Jogo(gerenciaJogadores);
        jogo.iniciarJogo();
    }
}