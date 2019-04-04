package test;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;
import com.ngxson.programmation.move.EmptyMove;
import com.ngxson.programmation.move.Move;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmptyMoveTest {

    @Test
    public void display() {
        List<Bottle> bottles = new ArrayList<>();
        bottles.add(new Bottle(10, 8, "b1"));
        bottles.add(new Bottle(10, 5, "b2"));
        Configuration config = new Configuration(bottles);

        EmptyMove move = new EmptyMove(bottles.get(0));
        move.apply(config);
        move.display();
        assertEquals(bottles.get(0).getWaterLevel(), 0);
        assertEquals(bottles.get(1).getWaterLevel(), 5);

        move.reverse(config);
        assertEquals(bottles.get(0).getWaterLevel(), 8);
        assertEquals(bottles.get(1).getWaterLevel(), 5);
    }
}