package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;

public class JogoNormal extends JogoBase {

    public JogoNormal(GerenciaJogadores gerenciaJogadores, String nomeJogador1, String nomeJogador2) {
        super(gerenciaJogadores, nomeJogador1, nomeJogador2);
    }

    @Override
    protected void realizarJogada(Jogador jogador) {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            int linha = Console.lerJogada("Linha da jogada (1-3): ");
            int coluna = Console.lerJogada("Coluna da jogada (1-3): ");
            try {
                jogadaValida = tabuleiro.fazerJogada(linha, coluna, jogador.getSimbolo());
            } catch (EntradaInvalidaException | PosicaoOcupadaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
