package com.ngxson.programmation;

import com.ngxson.programmation.move.Move;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //findSolutionFor2Bottles(3, 5, 0, 4);
        findSolutionFor2Bottles(131, 297, 0, 5);
    }

    private static void findSolutionFor2Bottles(int b1cap,
                                                int b2cap,
                                                int b1target,
                                                int b2target) {
        List<Bottle> bottles1 = new ArrayList<>();
        bottles1.add(new Bottle(b1cap, 0, "b1"));
        bottles1.add(new Bottle(b2cap, 0, "b2"));
        Configuration initConfig = new Configuration(bottles1);

        List<Bottle> bottles2 = new ArrayList<>();
        bottles2.add(new Bottle(b1cap, b1target, "b1"));
        bottles2.add(new Bottle(b2cap, b2target, "b2"));
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
