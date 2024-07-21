package armazenamento;

import java.io.*;
import java.util.*;

/**
 * Implementação de GerenciaJogadores que armazena as informações dos jogadores em um arquivo.
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores {
    private final String arquivo;

    /**
     * construtor que inicializa o arquivo para onde as informações dos jogadores serão enviadas
     * @param arquivo caminho ddo arquivo onde estão armazenados os jogadores
     */
    public GerenciaJogadoresArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Adiciona um novo jogador ao armazenamento, se ainda não estiver presente
     * @param nome nome do jogador a ser adicionado
     * @throws IOException Se ocorrer um erro de E/S ao carregar ou salvar os jogadores
     */
    @Override
    public void adicionarJogador(String nome) throws IOException {
        Map<String, Integer> jogadores = carregarJogadores();
        jogadores.putIfAbsent(nome, 0);
        salvarJogadores(jogadores);
    }

    /**
     * Incrementa o número de vitórias do jogador especificado
     * @param nome nome do jogador cuja vitória será incrementada
     * @throws IOException se ocorrer um erro de E/S ao carregar ou salvar os jogadores
     */
    @Override
    public void incrementarVitoria(String nome) throws IOException {
        Map<String, Integer> jogadores = carregarJogadores();
        jogadores.put(nome, jogadores.getOrDefault(nome, 0) + 1);
        salvarJogadores(jogadores);
    }

    /**
     * Obtém o número de vitórias do jogador especificado
     * @param nome nome do jogador
     * @return número de vitórias do jogador
     * @throws IOException se ocorrer um erro de E/S ao carregar os jogadores
     */
    @Override
    public int obterVitorias(String nome) throws IOException {
        Map<String, Integer> jogadores = carregarJogadores();
        return jogadores.getOrDefault(nome, 0);
    }

    /**
     * lista os nomes de todos os jogadores armazenados
     * @return lista de nomes de jogadores
     * @throws IOException se ocorrer um erro de E/S ao carregar os jogadores
     */
    @Override
    public List<String> listarJogadores() throws IOException {
        Map<String, Integer> jogadores = carregarJogadores();
        return new ArrayList<>(jogadores.keySet());
    }

    /**
     * carrega as informações para o arquivo
     * @return um mapa dos jogadores e suas vitórias 
     * @throws IOException se ocorrer um erro de E/S ao carregar os jogadores
     */
    private Map<String, Integer> carregarJogadores() throws IOException {
        Map<String, Integer> jogadores = new HashMap<>();
        File file = new File(arquivo);
        if (!file.exists()) {
            return jogadores;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                jogadores.put(partes[0], Integer.parseInt(partes[1]));
            }
        }
        return jogadores;
    }

    /**
     * escreve as informações e as salva no arquivo
     * @param jogadores jogadores e seus dados
     * @throws IOException se ocorrer um erro de E/S ao carregar os jogadores
     */
    private void salvarJogadores(Map<String, Integer> jogadores) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Map.Entry<String, Integer> entrada : jogadores.entrySet()) {
                writer.write(entrada.getKey() + "," + entrada.getValue());
                writer.newLine();
            }
        }
    }
}
