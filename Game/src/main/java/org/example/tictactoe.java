package org.example;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Game game = new Game();
        game.printBoard();
        Scanner sc = new Scanner(System.in);
        int playMore = 2;
        do {
            while (!game.canPlay()) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                game.playTurn(i, j);
                game.printBoard();
            }
            if (game.winner != null)
                System.out.println(game.winner.type + " is winner!!!");
            else
                System.out.println("It's a tie!!!");
            System.out.println("Want to play more ? \n Press 1 for new game \n Press 2 to quit");
            playMore = sc.nextInt();
        } while(playMore == 1);
        System.out.println(game.getTournamentWinner());
    }
}
