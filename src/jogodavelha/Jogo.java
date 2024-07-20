package jogodavelha;

import entradados.Console;
import java.io.IOException;
import java.util.Scanner;

import armazenamento.GerenciaJogadores;

/** A classe que representa o jogo da velha, gerenciando a lógica do jogo e a interação com os jogadores. */
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Jogada jogada;
    private GerenciaJogadores gerenciaJogadores;

    /**
     * construtor que inicializa o jogo da velha
     * @param gerenciaJogadores é onde os a pontuação e nome dos jogadores ficam alocados
     */
    public Jogo(GerenciaJogadores gerenciaJogadores) {
        this.gerenciaJogadores = gerenciaJogadores;
        tabuleiro = new Tabuleiro();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do jogador 1 (X): ");
        String nomeJogador1 = scanner.nextLine();
        jogador1 = new Jogador("X", 1, nomeJogador1);

        System.out.print("Nome do jogador 2 (O): ");
        String nomeJogador2 = scanner.nextLine();
        jogador2 = new Jogador("O", 2, nomeJogador2);

        jogadorAtual = jogador1;

        try {
            gerenciaJogadores.adicionarJogador(nomeJogador1);
            gerenciaJogadores.adicionarJogador(nomeJogador2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** inicializa o jogo, realizando turno entre jogadores e verifica se há vitória ou não */
    public void iniciarJogo() {
        while(!tabuleiro.tabuleiroCompleto()) {
            clearScreen();
            System.out.println("Vez de Jogador " + jogadorAtual.getNome());
            tabuleiro.imprimeTabuleiro();
            realizarJogada(jogadorAtual);
            if(tabuleiro.verificaVitoria(jogadorAtual.getSimbolo())) {
                tabuleiro.imprimeTabuleiro();
                System.out.println("O jogador " + jogadorAtual.getNome() + " venceu!");
                try {
                    gerenciaJogadores.incrementarVitoria(jogadorAtual.getNome());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            alternarTurno();
        }
        if(tabuleiro.tabuleiroCompleto()) {
            System.out.println("O jogo terminou em empate!");
        }
    }

    /** alterna o jogador atual da jogada */
    private void alternarTurno() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    /**
     * realiza a interface dos jogadores, permitindo selecionar a linha e a coluna da jogada
     * @param jogador utilizado para ver qual o simbolo do jogador
     */
    private void realizarJogada(Jogador jogador) {
        jogada = new Jogada();
        boolean jogadaValida;
        do {
            try {
                jogada.setLinha(Console.lerJogada("Linha da jogada(1-3): "));
                jogada.setColuna(Console.lerJogada("Coluna da jogada(1-3): "));
                jogadaValida = tabuleiro.fazerJogada(jogada.getLinha(), jogada.getColuna(), jogador.getSimbolo());
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
                jogadaValida = false;
                tabuleiro.imprimeTabuleiro();
            }
            catch(PosicaoOcupadaException e){
                System.out.println(e.getMessage());
                jogadaValida = false;
                tabuleiro.imprimeTabuleiro();
            }
            if(!jogadaValida) {
                System.out.println("Jogada inválida. Tente novamente.");
                tabuleiro.imprimeTabuleiro();
            }
        }
        while(!jogadaValida);
    }

    /** limpa a tela do terminal */
    public static void clearScreen() { //agr tá funfando
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
