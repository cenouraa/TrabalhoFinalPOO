package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;
import java.io.IOException;

/** classe que gerencia os modos de jogo */
public class GameManager {
    private GerenciaJogadores gerenciaJogadores;
    private String nomeJogador1;
    private String nomeJogador2;
    private int modoJogo;

    /**
     * construtor que passa as informações dos jogadores
     * @param gerenciaJogadores passa informações de jogadores
     */
    public GameManager(GerenciaJogadores gerenciaJogadores) {
        this.gerenciaJogadores = gerenciaJogadores;
    }

    /** inica o jogo */
    public void iniciar() {
        boolean continuarJogando = true;
        definirJogadores();
        while (continuarJogando) {
            if (nomeJogador1 == null || nomeJogador2 == null || modoJogo == 0) {
            }
            JogoBase jogo = criarJogo();
            jogo.iniciarJogo();
            mostrarPontuacao();
            continuarJogando = verificarJogarNovamente();
        }
    }

    /** define o nome dos jogadores */
    public void definirJogadores() {
        Console.clearScreen();
        nomeJogador1 = Console.lerNome("Nome do jogador 1 (X): ");
        nomeJogador2 = Console.lerNome("Nome do jogador 2 (O): ");
    }

    /**
     * cria o tipo de jogo escolhido
     * @return qual a opção de jogo escolhida
     */
    public JogoBase criarJogo() {
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

    /**
     * verifica se os jogadores querem jgar novamente
     * @return true se quiserem jogar novamente, se não false
     */
    public boolean verificarJogarNovamente() {
        System.out.println("Deseja jogar novamente? (0. Sim / 1. Não)");
        boolean resposta = Console.lerBoolean("Escolher: ");
        
        return resposta;
    }

    /** mostra o nome e a quantidade de pontos dos players */
    public void mostrarPontuacao() {
        try {
            System.out.println("Pontuação:");
            System.out.println(nomeJogador1 + ": " + gerenciaJogadores.obterVitorias(nomeJogador1) + " vitórias");
            System.out.println(nomeJogador2 + ": " + gerenciaJogadores.obterVitorias(nomeJogador2) + " vitórias");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}