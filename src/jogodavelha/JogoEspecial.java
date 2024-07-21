package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;
import java.util.LinkedList;
import java.util.Queue;

public class JogoEspecial extends JogoBase {
    private Queue<Jogada> jogadas;

    public JogoEspecial(GerenciaJogadores gerenciaJogadores, String nomeJogador1, String nomeJogador2) {
        super(gerenciaJogadores, nomeJogador1, nomeJogador2);
        jogadas = new LinkedList<>();
    }

    @Override
    protected void realizarJogada(Jogador jogador) {
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
