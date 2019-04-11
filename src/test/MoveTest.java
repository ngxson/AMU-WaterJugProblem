package test;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.move.EmptyMove;
import com.ngxson.programmation.move.FillMove;
import com.ngxson.programmation.move.Move;
import com.ngxson.programmation.move.PourMove;
import org.junit.jupiter.api.Test;

public class MoveTest {

    @Test
    public void andThen() {
        Bottle b1 = new Bottle(10, 0, "b1");
        Bottle b2 = new Bottle(20, 15, "b2");
        Bottle b3 = new Bottle(20, 5, "b3");

        Move moves = new PourMove(b2, b1)
                .andThen(new FillMove(b2))
                .andThen(new PourMove(b2, b3))
                .andThen(new EmptyMove(b3));
        moves.apply();
        moves.display();
        assertEquals(b1.getWaterLevel(), 10);
        assertEquals(b2.getWaterLevel(), 5);
        assertEquals(b3.getWaterLevel(), 0);

        moves.reverse();
        assertEquals(b1.getWaterLevel(), 0);
        assertEquals(b2.getWaterLevel(), 15);
        assertEquals(b3.getWaterLevel(), 5);
    }

    private void assertEquals(int waterLevel, int i) {
    }
}