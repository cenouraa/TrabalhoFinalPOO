package jogodavelha;
/** A classe que representa o tabuleiro do jogo da velha. */
public class Tabuleiro {
    private String[][] tabuleiro;

    /** construtor que inicializa o tabuleiro. */
    public Tabuleiro() {
        tabuleiro = new String[3][3];
    }

    /**
     * verifica se o tabuleiro está vazio
     * @return true se o tabuleiro estiver completo, caso contrário false.
     */
    public boolean tabuleiroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /** imprime todas as casas do tabuleiro*/
    public void imprimeTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] == null ? "-" : tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
        }
    }

    /**
     * realiza jogadas dos jogadores
     * @param linha linha onde o jogador decide fazer a jogada (1-3)
     * @param coluna coluna onde o jogador decide fazer jogada (1-3)
     * @param simbolo simbolo do jogador atual (X ou O)
     * @return true se tudo ocorreu como devido, se não false
     * @throws EntradaInvalidaException se a linha ou a coluna for invalida
     * @throws PosicaoOcupadaException se a posição já estiver ocupada por outro jogador
     */
    public boolean fazerJogada(int linha, int coluna, String simbolo) throws EntradaInvalidaException, PosicaoOcupadaException{
        if(linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3){
            throw new EntradaInvalidaException("você não pode digitar um caracter inválido para o jogo, só são aceitos números inteiros");
        }
        if (tabuleiro[linha][coluna] != null) {
            throw new PosicaoOcupadaException(linha, coluna);
        }
        tabuleiro[linha][coluna] = simbolo;
        return true;
    }

    /**
     * verifica se o jogador ganhou de algum dos tipos possíveis
     * @param simbolo simbolo utilizado pelo jogador atual
     * @return true se ele ganhou de alguma das formas, ao contrário false
     */
    public boolean verificaVitoria(String simbolo) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                return true;
            }
        }
        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo) {
                return true;
            }
        }
        // Verifica diagonais
        if (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) {
            return true;
        }
        if (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo) {
            return true;
        }
        return false;
    }
}