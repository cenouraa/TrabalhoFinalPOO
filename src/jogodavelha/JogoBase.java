package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;
import java.io.IOException;

public abstract class JogoBase {
    protected Tabuleiro tabuleiro;
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected Jogador jogadorAtual;
    protected Jogada jogada;
    protected GerenciaJogadores gerenciaJogadores;

    public JogoBase(GerenciaJogadores gerenciaJogadores, String nomeJogador1, String nomeJogador2) {
        this.gerenciaJogadores = gerenciaJogadores;
        tabuleiro = new Tabuleiro();

        jogador1 = new Jogador("X", 1, nomeJogador1);
        jogador2 = new Jogador("O", 2, nomeJogador2);

        jogadorAtual = jogador1;

        try {
            gerenciaJogadores.adicionarJogador(nomeJogador1);
            gerenciaJogadores.adicionarJogador(nomeJogador2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void iniciarJogo() {
        while (!tabuleiro.tabuleiroCompleto()) {
            Console.clearScreen();
            System.out.println("Vez de Jogador " + jogadorAtual.getNome());
            tabuleiro.imprimeTabuleiro();
            realizarJogada(jogadorAtual);
            if (tabuleiro.verificaVitoria(jogadorAtual.getSimbolo())) {
                Console.clearScreen();
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
        if (tabuleiro.tabuleiroCompleto()) {
            System.out.println("O jogo terminou em empate!");
        }
    }

    private void alternarTurno() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    protected abstract void realizarJogada(Jogador jogador);
}
