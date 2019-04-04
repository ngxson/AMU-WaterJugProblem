package com.ngxson.programmation.move;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;

public class PourMove implements Move {
    private int amountProcessed = 0;
    private Bottle bottle1;
    private Bottle bottle2;

    public PourMove(Bottle fromBottle, Bottle toBottle) {
        this.bottle1 = fromBottle;
        this.bottle2 = toBottle;
    }

    public void apply(Configuration configuration) {
        int amountBefore = 0;
        Bottle mBottle1 = bottle1;
        Bottle mBottle2 = bottle2;
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle1)) {
                mBottle1 = mBottle;
                amountBefore = mBottle.getWaterLevel();
                break;
            }
        }
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle2)) {
                mBottle2 = mBottle;
                break;
            }
        }
        mBottle1.pourAllTo(mBottle2);

        amountProcessed = mBottle1.getWaterLevel() - amountBefore;
    }

    public void reverse(Configuration configuration) {
        Bottle mBottle1 = bottle1;
        Bottle mBottle2 = bottle2;
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle1)) {
                mBottle1 = mBottle;
                break;
            }
        }
        for (Bottle mBottle : configuration.getBottles()) {
            if (mBottle.equals(bottle2)) {
                mBottle2 = mBottle;
                break;
            }
        }
        mBottle1.pour(-amountProcessed);
        mBottle2.pour(-amountProcessed);
        amountProcessed = 0;
    }

    public void display() {
        System.out.format("Pour %dL from bottle %s to bottle %s.",
                amountProcessed,
                bottle1.getName(),
                bottle2.getName()
        );
    }
}
