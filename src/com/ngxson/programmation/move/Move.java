package com.ngxson.programmation.move;

public interface Move {
    /**
     * apply the move to a bottle
     */
    void apply();

    /**
     * reverse the move applied to a bottle
     */
    void reverse();

    /**
     * display the move applied to a bottle
     */
    void display();

    /**
     * Chaining a sequence of moves
     * @param move the Move
     * @return the CombineMove
     */
    default Move andThen(Move move) {
        return new CombinedMove(this, move);
    }
}
