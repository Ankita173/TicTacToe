package org.example;

public class Player {
    int id;
    Piecetype type;
    int totalGamePlayed;
    int totalWins;

    public Player (int id, Piecetype p) {
        this.id = id;
        this.type = p;
    }

    public float winPercentage() {
        return (totalWins * 100 )/ totalGamePlayed;
    }

    public void recordWin() {
        totalGamePlayed++;
        totalWins++;
    }

    public void recordPlay() {
        totalGamePlayed++;
    }
}
