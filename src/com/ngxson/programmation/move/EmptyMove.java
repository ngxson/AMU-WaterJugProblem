package com.ngxson.programmation.move;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;

public class EmptyMove implements Move {
    private int amountProcessed = 0;
    private Bottle bottle;

    public EmptyMove(Bottle bottle) {
        this.bottle = bottle;
    }

    public void apply() {
        amountProcessed = -bottle.makeEmpty();
    }

    public void reverse() {
        bottle.pourIn(amountProcessed);
    }

    public void display() {
        System.out.format("Empty %dL from bottle %s.\n",
                amountProcessed,
                bottle.getName()
        );
    }
}
