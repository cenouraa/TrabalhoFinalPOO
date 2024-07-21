package armazenamento;

import java.util.*;

/**
 * Implementação de GerenciaJogadores que armazena as informações dos jogadores em um ArrayList.
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores {
    private final Map<String, Integer> jogadores;

    /** construtor que cria o hash map para armazenar os jogadores e suas vitórias */
    public GerenciaJogadoresArrayList() {
        this.jogadores = new HashMap<>();
    }

    /** nome do jogador a ser adicionado 
     * @param nome nome do jogador
    */
    @Override
    public void adicionarJogador(String nome) {
        jogadores.putIfAbsent(nome, 0);
    }

    /** incremeta as vitórias do jogador
     * @param nome nome do jogadr que será incrementada a vitória
    */
    @Override
    public void incrementarVitoria(String nome) {
        jogadores.put(nome, jogadores.getOrDefault(nome, 0) + 1);
    }

    /** obtem a quantidade de vitorias do jogador
     * @param nome nome do jogador para obter as vitorias
     */
    @Override
    public int obterVitorias(String nome) {
        return jogadores.getOrDefault(nome, 0);
    }

    /** retorna o array de jogadores
     * @return array de jogadores
     */
    @Override
    public List<String> listarJogadores() {
        return new ArrayList<>(jogadores.keySet());
    }
}