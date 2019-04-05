package com.ngxson.programmation.move;

public class CombinedMove implements Move {

    private Move move1;
    private Move move2;

    public CombinedMove(Move move1, Move move2) {
        this.move1 = move1;
        this.move2 = move2;
    }

    @Override
    public void apply() {
        move1.apply();
        move2.apply();
    }

    @Override
    public void reverse() {
        move2.reverse();
        move1.reverse();
    }

    @Override
    public void display() {
        move1.display();
        move2.display();
    }
}
