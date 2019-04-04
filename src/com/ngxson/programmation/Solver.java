package com.ngxson.programmation;

import com.ngxson.programmation.move.Move;

import java.util.List;

public class Solver {
    private Configuration initConfig;
    private Configuration targetConfig;

    public Solver(Configuration initConfig, Configuration targetConfig) {
        this.initConfig = initConfig;
        this.targetConfig = targetConfig;
    }

    public boolean isWinningMove(Move move) {
        move.apply(initConfig);
        boolean isWin = initConfig.equals(targetConfig);
        move.reverse(initConfig);
        return isWin;
    }

    public Move findWinningMove() {
        List<Move> possibleMoves = initConfig.possibleMoves();
        for (Move move : possibleMoves) {
            if (isWinningMove(move)) return move;
        }
        return null;
    }
}
