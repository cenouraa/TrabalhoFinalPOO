package jogodavelha;

import armazenamento.GerenciaJogadoresArrayList;

/** classe que gerencia as jogadas */
public class Jogador {
    private String simbolo;
    private int valor;
    private String nome;

    /**
     * construtor que atualiza o jogador
     * @param simbolo simbolo do jogador atual (X ou O)
     * @param valor quantidade de vitorias do jogador
     * @param nome nome do jogador atual
     */
    public Jogador(String simbolo, int valor, String nome) {
        this.simbolo = simbolo;
        this.valor = valor;
        this.nome = nome;
    }

    /**
     * retorn o nome do jogador atual
     * @return nome do jogador atual
     */
    public String getNome() { return nome; }

    /**
     * define o nome do jogador
     * @param nome novo nome do jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * retorna o simbolo do jogador
     * @return simbolo do jogador atual
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * retorna o valor do jogador
     * @return valor do jogador
     */
    public int getValor() {
        return valor;
    }
}
