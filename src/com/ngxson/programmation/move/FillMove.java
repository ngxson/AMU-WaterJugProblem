package com.ngxson.programmation.move;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;

public class FillMove implements Move {
    private int amountProcessed = 0;
    private Bottle bottle;

    public FillMove(Bottle bottle) {
        this.bottle = bottle;
    }

    public void apply(Configuration configuration) {
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle)) {
                amountProcessed = mBottle.makeFull();
                return;
            }
        }
    }

    public void reverse(Configuration configuration) {
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle)) {
                mBottle.pourIn(-amountProcessed);
                //amountProcessed = 0;
                return;
            }
        }
    }

    public void display() {
        System.out.format("Fill %dL in bottle %s.\n",
                amountProcessed,
                bottle.getName()
        );
    }
}
