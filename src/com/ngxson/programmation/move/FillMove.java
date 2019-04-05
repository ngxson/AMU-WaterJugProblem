package com.ngxson.programmation.move;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;

public class FillMove implements Move {
    private int amountProcessed = 0;
    private Bottle bottle;

    public FillMove(Bottle bottle) {
        this.bottle = bottle;
    }

    public void apply() {
        amountProcessed = bottle.makeFull();
    }

    public void reverse() {
        bottle.pourIn(-amountProcessed);
    }

    public void display() {
        System.out.format("Fill %dL in bottle %s.\n",
                amountProcessed,
                bottle.getName()
        );
    }
}
