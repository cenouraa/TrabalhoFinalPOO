package jogodavelha;

import armazenamento.GerenciaJogadores;
import armazenamento.GerenciaJogadoresArquivo;
import entradados.*;

/** classe main para funcionamento do jogo */
public class App {
    /**
     * Método principal que inicializa a gerência de jogadores e inicia o jogo.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        Console.clearScreen();
        
        GerenciaJogadores gerenciaJogadores = new GerenciaJogadoresArquivo("jogadores.txt"); // ou new GerenciaJogadoresArrayList();
        JogoBase jogo;
        GameMenu menu = new GameMenu();

        int escolha = menu.displayMenu();

        switch (escolha) {
            case 1:
                System.out.println("Modo escolhido: Clássico");
                jogo = new JogoNormal(gerenciaJogadores);
                break;
            case 2:
                System.out.println("Modo escolhido: Especial");
                jogo = new JogoEspecial(gerenciaJogadores);
                break;
            case 0:
                System.out.println("Saindo...");
                return; // Encerra a aplicação
            default:
                System.out.println("Escolha inválida");
                return; // Encerra a aplicação
        }

        jogo.iniciarJogo();
    }
}