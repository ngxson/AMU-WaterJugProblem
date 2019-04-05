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

    public void apply() {
        int amountBefore = 0;
        amountBefore = bottle1.getWaterLevel();
        bottle1.pourAllTo(bottle2);

        amountProcessed = amountBefore - bottle1.getWaterLevel();
    }

    public void reverse() {
        bottle1.pourIn(amountProcessed);
        bottle2.pourIn(-amountProcessed);
        //amountProcessed = 0;
    }

    public void display() {
        System.out.format("Pour %dL from bottle %s to bottle %s.\n",
                amountProcessed,
                bottle1.getName(),
                bottle2.getName()
        );
    }
}
