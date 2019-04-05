package com.ngxson.programmation.move;

public class IdentityMove implements Move {

    private Move move;

    public IdentityMove(Move move) {
        this.move = move;
    }

    @Override
    public void apply() {
        move.apply();
    }

    @Override
    public void reverse() {
        move.reverse();
    }

    @Override
    public void display() {
        move.display();
    }
}
