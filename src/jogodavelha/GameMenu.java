package jogodavelha;

import entradados.*;

public class GameMenu {

    public GameMenu() {
        
    }

    public int displayMenu() {
        int escolha = -1;
        boolean gameStatus = true;

        while(gameStatus) {
            printMenu();

            System.out.print("Escolha uma opção: ");
            try {
                escolha = Console.lerInt();
                if (escolha == 1 || escolha == 2 || escolha == 0) {
                    gameStatus = false;
                } else {
                    Console.clearScreen();
                    throw new IllegalArgumentException("Opção inválida. Tente novamente!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Console.clearScreen();
        return escolha;
    }

    private void printMenu() {
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1. Modo Clássico");
        System.out.println("2. Modo Especial");
        System.out.println("0. Sair");
    }
}
