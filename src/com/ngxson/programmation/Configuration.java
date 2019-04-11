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

    @Override
    public boolean equals(Object object) {
        return equals((Configuration) object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottles);
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

    public void display() {
        for (Bottle bottle : bottles) {
            System.out.format("%s: %dL - ",
                    bottle.getName(),
                    bottle.getWaterLevel()
            );
        }
        System.out.format("\n");
    }

    public List<Bottle> getBottles() {
        return bottles;
    }

    @Override
    public Configuration clone() {
        List<Bottle> newBottles = new ArrayList<>();
        for (Bottle bottle : bottles) {
            newBottles.add(new Bottle(
                    bottle.getCapacity(),
                    bottle.getWaterLevel(),
                    bottle.getName()
            ));
        }
        return new Configuration(newBottles);
    }
}
