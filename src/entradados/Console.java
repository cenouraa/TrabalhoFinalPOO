package entradados;

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
        try{
            return Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println();
            return 0;
        }
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

    public static boolean lerBoolean(String mensagem) {
        System.out.print(mensagem);
        String resposta = scanner.next();
        scanner.nextLine(); 
        return resposta.equals("0");
    }

    public static void clearScreen() {
        System.out.print("\033[2J\033[H"); // Código ANSI para limpar a tela
        System.out.flush();
    }
}