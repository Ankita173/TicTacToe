package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    int turn;
    int prevI;
    int prevJ;
    Player winner;

    public Game() {
        Player p1 = new Player(1, Piecetype.o);
        Player p2 = new Player(2, Piecetype.x);
        this.players = new ArrayList<Player>();
        this.players.add(p1);
        this.players.add(p2);
        this.board = new Board();
        this.turn = 0;
        this.prevI = -1;
        this.prevJ = -1;
        this.winner = null;
    }

    boolean canPlay() {
        if (isWinner() || turn > 8) {
            System.out.println("Game is over");
            return true;
        }
        return false;
    }

    private boolean isWinner() {
        if (prevI == -1 || prevJ == -1) {
            return false;
        }
        if(isVerticalWin() || isHorizontalWin() || isDiagonalWin()) {
            winner = players.get((turn - 1) % 2);
            winner.recordWin();
            return true;
        }
        return false;
    }

    private boolean isVerticalWin() {
        for (int i = 0; i < 3; i++) {
            if (board.board[prevI][prevJ] != board.board[i][prevJ]) return false;
        }
        return true;
    }

    private boolean isHorizontalWin() {
        for (int j = 0; j < 3; j++) {
            if (board.board[prevI][prevJ] != board.board[prevI][j]) return false;
        }
        return true;
    }

    private boolean isDiagonalWin() {
        if (prevJ == prevI) {
             return isForwardDiagonalWin();
        } else if(prevJ == 1 && prevI == 1) {
            if (isForwardDiagonalWin() || isBackwardDiagonalWin()) return true;
            return false;
        }
        return isBackwardDiagonalWin();
    }

    private boolean isForwardDiagonalWin() {
        for (int j = 0; j < 3; j++) {
            if (board.board[prevI][prevJ] != board.board[j][j]) return false;
        }
        return true;
    }

    private boolean isBackwardDiagonalWin() {
        for (int j = 0; j < 3; j++) {
            if (board.board[prevI][prevJ] != board.board[j][2 - j]) return false;
        }
        return true;
    }

    public void playTurn(int i, int j) {
        if (i < 3 && j < 3 && board.board[i][j] == null) {
            board.board[i][j] = players.get(turn % 2).type;
            turn++;
            prevI = i;
            prevJ = j;
        } else System.out.println("Invalid move, Try Again!");
    }

    public void printBoard() {
        board.printBoard();
    }

    public Player getTournamentWinner() {
        Player winner = players.get(0);
        for (Player p : players) {
            if(winner.winPercentage() < p.winPercentage())
                winner = p;
        }
        return winner;
    }
}
