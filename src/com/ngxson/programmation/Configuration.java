package com.ngxson.programmation;

import com.ngxson.programmation.move.EmptyMove;
import com.ngxson.programmation.move.FillMove;
import com.ngxson.programmation.move.Move;
import com.ngxson.programmation.move.PourMove;

import java.util.*;

public class Configuration {
    private List<Bottle> bottles;

    public Configuration(List<Bottle> bottles) {
        this.bottles = bottles;
    }

    public boolean equals(Configuration config) {
        List<Bottle> mBottles = config.getBottles();
        if (mBottles.size() != bottles.size())
            return false;
        for (int i = 0 ; i < mBottles.size() ; i++) {
            if (!mBottles.get(i).equals(bottles.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<Move> possibleMoves() {
        List<Move> moves = new ArrayList<>();
        for (Bottle bottle : bottles) {
            if (!bottle.isFull()) {
                moves.add(new FillMove(bottle));
            }
            if (!bottle.isEmpty()) {
                moves.add(new EmptyMove(bottle));
                findPourMove(moves, bottle);
            }
        }
        return moves;
    }

    private void findPourMove(List<Move> moves, Bottle bottle) {
        for (Bottle bottle2 : bottles) {
            if (!bottle2.isFull() && !bottle.equals(bottle2)) {
                moves.add(new PourMove(bottle, bottle2));
            }
        }
    }

    public List<Bottle> getBottles() {
        return bottles;
    }
}
