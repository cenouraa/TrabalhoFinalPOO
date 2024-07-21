package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;
import java.io.IOException;

public class GameManager {
    private GerenciaJogadores gerenciaJogadores;
    private String nomeJogador1;
    private String nomeJogador2;
    private int modoJogo;

    public GameManager(GerenciaJogadores gerenciaJogadores) {
        this.gerenciaJogadores = gerenciaJogadores;
    }

    public void iniciar() {
        boolean continuarJogando = true;
        while (continuarJogando) {
            if (nomeJogador1 == null || nomeJogador2 == null || modoJogo == 0) {
                definirJogadoresEModo();
            }
            JogoBase jogo = criarJogo();
            jogo.iniciarJogo();
            mostrarPontuacao();
            continuarJogando = verificarJogarNovamente();
        }
    }

    private void definirJogadoresEModo() {
        Console.clearScreen();
        nomeJogador1 = Console.lerNome("Nome do jogador 1 (X): ");
        nomeJogador2 = Console.lerNome("Nome do jogador 2 (O): ");
    }

    private JogoBase criarJogo() {
        GameMenu menu = new GameMenu();

        switch (menu.displayMenu()) {
            case 1:
                return new JogoNormal(gerenciaJogadores, nomeJogador1, nomeJogador2);
            case 2:
                return new JogoEspecial(gerenciaJogadores, nomeJogador1, nomeJogador2);
            default:
                return null;
        }
    }

    private boolean verificarJogarNovamente() {
        System.out.println("Deseja jogar novamente? (0. Sim / 1. Não)");
        boolean resposta = Console.lerBoolean("Escolher: ");
        
        return resposta;
    }

    private void mostrarPontuacao() {
        try {
            System.out.println("Pontuação:");
            System.out.println(nomeJogador1 + ": " + gerenciaJogadores.obterVitorias(nomeJogador1) + " vitórias");
            System.out.println(nomeJogador2 + ": " + gerenciaJogadores.obterVitorias(nomeJogador2) + " vitórias");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}