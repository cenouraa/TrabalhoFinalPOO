package jogodavelha;

import entradados.*;

/** classe que mostra o menu de opções possivei de se jogar */
public class GameMenu {

    /** construtor padrão */
    public GameMenu() {}

    /**
     * lógica da escolha do jogador
     * @return escolha do modo do jogador
     */
    public int displayMenu() {
        int escolha = -1;
        boolean gameStatus = true;

        while(gameStatus) {
            Console.clearScreen();
            printMenu();

            System.out.print("Escolha uma opção: ");
            try {
                escolha = Console.lerInt();
                if (escolha == 1 || escolha == 2) {
                    gameStatus = false;
                } else {
                    Console.clearScreen();
                    throw new IllegalArgumentException("Opção inválida. Tente novamente!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return escolha;
    }

    /** mostra as opções possíveis do menu */
    public void printMenu() {
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1. Modo Clássico");
        System.out.println("2. Modo Especial");
    }
}
