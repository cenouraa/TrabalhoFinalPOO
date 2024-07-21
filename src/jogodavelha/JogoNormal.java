package jogodavelha;

import armazenamento.GerenciaJogadores;
import entradados.Console;

public class JogoNormal extends JogoBase {

    public JogoNormal(GerenciaJogadores gerenciaJogadores) {
        super(gerenciaJogadores);
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
                }
            } catch (EntradaInvalidaException | PosicaoOcupadaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
