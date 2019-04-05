package test;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;
import com.ngxson.programmation.move.FillMove;
import com.ngxson.programmation.move.PourMove;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PourMoveTest {

    @Test
    public void display() {
        List<Bottle> bottles = new ArrayList<>();
        bottles.add(new Bottle(10, 8, "b1"));
        bottles.add(new Bottle(10, 5, "b2"));
        Configuration config = new Configuration(bottles);

        PourMove move = new PourMove(bottles.get(0), bottles.get(1));
        move.apply();
        move.display();
        assertEquals(bottles.get(0).getWaterLevel(), 3);
        assertEquals(bottles.get(1).getWaterLevel(), 10);

        move.reverse();
        assertEquals(bottles.get(0).getWaterLevel(), 8);
        assertEquals(bottles.get(1).getWaterLevel(), 5);
    }
}