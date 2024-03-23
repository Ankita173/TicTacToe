package org.example;

public class Board {
    Piecetype[][] board;

    public Board() {
        board = new Piecetype[3][3];
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print("|  " + (board[i][j] == null ? " " : board[i][j])+ "  |");
            }
            System.out.println();
        }
    }
}
