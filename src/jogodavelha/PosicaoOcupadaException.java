package jogodavelha;
/** classe que mostra a exceção de posição já ocupada */
public class PosicaoOcupadaException extends Exception{

    /**
     * construtor que mostra a mensagem de erro
     * @param linha linha da jogada para mostrar onde não podeia jogar
     * @param coluna coluna da jogada para mostrar onde não podeia jogar
     */
    PosicaoOcupadaException(int linha, int coluna){
        super("Posição ocupada! Linha: " + (linha + 1) + ", Coluna: " + (coluna + 1));
    }
}
