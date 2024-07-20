package armazenamento;

import java.io.IOException;
import java.util.List;

/**
 * Interface para gerenciar o armazenamento de informações dos jogadores.
 */
public interface GerenciaJogadores {
    void adicionarJogador(String nome) throws IOException;
    void incrementarVitoria(String nome) throws IOException;
    int obterVitorias(String nome) throws IOException;
    List<String> listarJogadores() throws IOException;
}
