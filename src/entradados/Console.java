package entradados;

import jogodavelha.Jogada;
import jogodavelha.Jogador;
import jogodavelha.Tabuleiro;

import java.util.Scanner;

/** classe para entrar dados do terminal */
public class Console {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * construtor padrão
     * @param scanner dado que irá ler
     */
    public Console(Scanner scanner) {
    }

    /**
     * retorna onde será a jogada do jogador
     * @param mensagem jogada feita pelo jogador
     * @return onde será a jogada do jogador
     */
    public static int lerJogada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt() - 1;
    }

    /**
     * retorna o valor do terminal
     * @return valor inteiro do termial
     */
    public static int lerInt() {
        return scanner.nextInt();
    }

    /**
     * lê o nome do jogador
     * @param mensagem nome do jogador colocado no termial
     * @return nome do jogador
     */
    public static String lerNome(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /*public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número inteiro válido.");
            scanner.next();
            System.out.print(mensagem);
        }
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }*/
}