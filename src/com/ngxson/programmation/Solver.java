package com.ngxson.programmation;

import com.ngxson.programmation.move.Move;

import java.util.*;

public class Solver {
    private Configuration initConfig;
    private Configuration targetConfig;
    private Deque<Move> candidateMoves;
    private Set<Configuration> reachedConfigurations;

    public Solver(Configuration initConfig, Configuration targetConfig) {
        this.initConfig = initConfig;
        this.targetConfig = targetConfig;
        this.candidateMoves = new ArrayDeque<>();
        this.reachedConfigurations = new HashSet<>();
    }

    public boolean isWinningMove(Move move) {
        move.apply();
        boolean isWin = initConfig.equals(targetConfig);
        move.reverse();
        return isWin;
    }

    /**
     * Based on Dijkstra's algorithm
     * @return the winningMove, null if cannot find
     */
    public Move findWinningMove() {
        Move nextMove = null;
        // repeat for every moves in the queue,
        // and stop if the queue is empty
        do {
            Move winningMove = findWinningMoveFromMove(nextMove);
            // if we found the winningMove, return it immediately
            if (winningMove != null) {
                return winningMove;
            }
            nextMove = candidateMoves.pollFirst();
        } while (nextMove != null);

        return null;
    }

    /**
     * Find the winningMove from lastMove
     * and push nextMove to the queue if it's possible
     *
     * @param lastMove null if we call the first time
     * @return the winningMove, null if cannot find
     */
    public Move findWinningMoveFromMove(Move lastMove) {
        // bump to this node on the tree
        if (lastMove != null) lastMove.apply();

        // debug
        /*if (lastMove != null) lastMove.display();
        System.out.print(" - ");
        initConfig.display();
        System.out.print("\n");*/

        // dynamic programming: check reachedConfigurations
        if (reachedConfigurations.contains(initConfig)) {
            if (lastMove != null) lastMove.reverse();
            return null;
        }

        // find all child nodes and check it
        List<Move> possibleMoves = initConfig.possibleMoves();
        for (Move nextMove : possibleMoves) {
            if (isWinningMove(nextMove)) {
                // if isWinningMove is true, return it immediately
                return (lastMove == null)
                        ? nextMove
                        : lastMove.andThen(nextMove);
            } else {
                // if not, add this child node to queue
                enqueueNewMoves(lastMove, nextMove);
            }
        }

        // dynamic programming: save this configuration
        reachedConfigurations.add(initConfig.clone());

        // go back to root of the tree
        if (lastMove != null) lastMove.reverse();

        return null;
    }

    private void enqueueNewMoves(Move lastMove, Move nextMove) {
        candidateMoves.offerLast(
                (lastMove == null)
                    ? nextMove
                    : lastMove.andThen(nextMove)
        );
    }
}
