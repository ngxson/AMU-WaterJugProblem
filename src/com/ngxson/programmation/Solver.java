package com.ngxson.programmation;

import com.ngxson.programmation.move.Move;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solver {
    private Configuration initConfig;
    private Configuration targetConfig;
    private Deque<Move> candidateMoves;

    public Solver(Configuration initConfig, Configuration targetConfig) {
        this.initConfig = initConfig;
        this.targetConfig = targetConfig;
        this.candidateMoves = new ArrayDeque<>();
    }

    public boolean isWinningMove(Move move) {
        move.apply();
        boolean isWin = initConfig.equals(targetConfig);
        move.reverse();
        return isWin;
    }

    /**
     * Based on Dijkstra's algorithm
     * @param lastMove null if we call the first time
     * @return the winningMove, null if cannot find
     */
    public Move findWinningMove(Move lastMove) {
        // bump to this node on the tree
        if (lastMove != null) lastMove.apply();
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
        // go back to root of the tree
        if (lastMove != null) lastMove.reverse();

        return null;
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
            // call findWinningMove recursively
            // that means we go down 1 stage of the tree
            Move winningMove = findWinningMove(nextMove);
            // if we found the winningMove, return it immediately
            if (winningMove != null) {
                return winningMove;
            }
            nextMove = candidateMoves.pollFirst();
        } while (nextMove != null);

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
