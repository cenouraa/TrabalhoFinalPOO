package jogodavelha;

/** classe da jogada do jogador */
public class Jogada {
    private int linha;
    private int coluna;
    private String simbolo;

    /**
     * consrutor para atualizar as jogadas
     * @param linha linha que o jogador escolheu
     * @param coluna coluna que o jogador escolheu
     * @param simbolo simbolo atual do jogador
     */
    public Jogada(int linha, int coluna, String simbolo) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
    }

    /**
     * retorna a linha da jogada
     * @return linha da jogada
     */
    public int getLinha() {
        return linha;
    }

    /**
     * modifica a linha da jogada
     * @param linha linha da jogada
     */
    public void setLinha(int linha) {
        this.linha = linha;
    }

    /**
     * retorna a coluna da jogada
     * @return coluna da jogada
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * modifica a coluna da jogada
     * @param coluna coluna da jogada
     */
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    /**
     * retorna o simbolo do jogador atual
     * @return simbolo do jogador atual
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * modifica o simbolo do jogador
     * @param simbolo simbolo do jogador atual
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
