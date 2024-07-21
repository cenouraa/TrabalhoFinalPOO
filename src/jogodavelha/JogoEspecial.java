package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;
import java.util.LinkedList;
import java.util.Queue;

public class JogoEspecial extends JogoBase {
    private Queue<Jogada> jogadasJogador1;
    private Queue<Jogada> jogadasJogador2;
    private int jogadasJogador2Contador;

    public JogoEspecial(GerenciaJogadores gerenciaJogadores) {
        super(gerenciaJogadores);
        jogadasJogador1 = new LinkedList<>();
        jogadasJogador2 = new LinkedList<>();
        jogadasJogador2Contador = 0;
    }

    @Override
    protected void realizarJogada(Jogador jogador) {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            int linha = Console.lerJogada("Escolha a linha (1-3): ");
            int coluna = Console.lerJogada("Escolha a coluna (1-3): ");
            try {
                if (tabuleiro.fazerJogada(linha, coluna, jogador.getSimbolo())) {
                    jogada = new Jogada(linha, coluna, jogador.getSimbolo());
                    jogadaValida = true;

                    if (jogador == jogador1) {
                        jogadasJogador1.add(jogada);
                        if (jogadasJogador1.size() > 3) {
                            Jogada jogadaRemovida = jogadasJogador1.poll();
                            tabuleiro.removeJogada(jogadaRemovida);
                        }
                    } else {
                        jogadasJogador2.add(jogada);
                        jogadasJogador2Contador++;
                        if (jogadasJogador2Contador > 3) {
                            Jogada jogadaRemovida = jogadasJogador2.poll();
                            tabuleiro.removeJogada(jogadaRemovida);
                        }
                    }
                }
            } catch (EntradaInvalidaException | PosicaoOcupadaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
