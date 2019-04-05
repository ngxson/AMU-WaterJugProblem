package com.ngxson.programmation;

import com.ngxson.programmation.move.Move;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        exercice6();
    }

    private static void exercice6() {
        List<Bottle> bottles1 = new ArrayList<>();
        bottles1.add(new Bottle(3, 0, "b1"));
        bottles1.add(new Bottle(5, 0, "b2"));
        Configuration initConfig = new Configuration(bottles1);

        List<Bottle> bottles2 = new ArrayList<>();
        bottles2.add(new Bottle(3, 3, "b1"));
        bottles2.add(new Bottle(5, 0, "b2"));
        Configuration targetConfig = new Configuration(bottles2);

        Solver solver = new Solver(initConfig, targetConfig);

        Move winningMove = solver.findWinningMove();

        if (winningMove != null) {
            winningMove.display();
        } else {
            System.out.println("Cannot find winning move");
        }
    }
}
