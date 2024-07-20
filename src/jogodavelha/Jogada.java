package jogodavelha;
/** classe que realiza jogada */
public class Jogada {
    private int linha;
    private int coluna;

    /** construtor da classe */
    public Jogada() {
        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * modifica a coluna da jogada
     * @param coluna modifica a coluna para a jogada
     */
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    /**
     * retorna coluna da jogada
     * @return coluna da jogada
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * modifica a linha da jogada
     * @param linha modifica a linha da jogada
     */
    public void setLinha(int linha) {
        this.linha = linha;
    }

    /**
     * retorna a linha da jogada
     * @return a linha da jogada
     */
    public int getLinha() {
        return linha;
    }
}
