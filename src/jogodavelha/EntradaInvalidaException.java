package jogodavelha;

/** classe exceção */
public class EntradaInvalidaException extends Exception{

    /**
     * construtor para mostrar a mensagem de erro
     * @param mensagem retorna a mensagem desejada para a exceção
     */
    public EntradaInvalidaException(String mensagem){
        super(mensagem);
    }
}