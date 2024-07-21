package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;
import java.util.LinkedList;
import java.util.Queue;

/** classe do modo de jogo especial */
public class JogoEspecial extends JogoBase {
    private Queue<Jogada> jogadas;

    /**
     * construtor que cria uma lista
     * @param gerenciaJogadores informações dos jogadores
     * @param nomeJogador1 passa o nome do primeiro jogador
     * @param nomeJogador2 passa o nome do segundo jogador
     */
    public JogoEspecial(GerenciaJogadores gerenciaJogadores, String nomeJogador1, String nomeJogador2) {
        super(gerenciaJogadores, nomeJogador1, nomeJogador2);
        jogadas = new LinkedList<>();
    }

    /** 
     * realiza as jogadas do player, e as remove caso a quantidade de jogadas tenha excedido 3
     * @param jogador jogador que fará a jogada atual
     */
    @Override
    public void realizarJogada(Jogador jogador) {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            int linha = Console.lerJogada("Linha da jogada (1-3): ");
            int coluna = Console.lerJogada("Coluna da jogada (1-3): ");
            try {
                jogadaValida = tabuleiro.fazerJogada(linha, coluna, jogador.getSimbolo());
                Jogada jogada = new Jogada(linha, coluna, jogador.getSimbolo());
                jogadas.add(jogada);

                if (jogadas.size() > 6) {
                    Jogada jogadaRemovida = jogadas.poll();
                    tabuleiro.removeJogada(jogadaRemovida);
                }

            } catch (EntradaInvalidaException | PosicaoOcupadaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
