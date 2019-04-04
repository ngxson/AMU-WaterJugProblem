package com.ngxson.programmation.move;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;

public class EmptyMove implements Move {
    private int amountProcessed = 0;
    private Bottle bottle;

    public EmptyMove(Bottle bottle) {
        this.bottle = bottle;
    }

    public void apply(Configuration configuration) {
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle)) {
                amountProcessed = mBottle.makeEmpty();
                return;
            }
        }
    }

    public void reverse(Configuration configuration) {
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle)) {
                mBottle.pour(amountProcessed);
                amountProcessed = 0;
                return;
            }
        }
    }

    public void display() {
        System.out.format("Empty %dL from bottle %s.",
                amountProcessed,
                bottle.getName()
        );
    }
}
