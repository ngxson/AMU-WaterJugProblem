package test;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;
import com.ngxson.programmation.move.EmptyMove;
import com.ngxson.programmation.move.FillMove;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FillMoveTest {

    @Test
    public void display() {
        List<Bottle> bottles = new ArrayList<>();
        bottles.add(new Bottle(10, 8, "b1"));
        bottles.add(new Bottle(10, 5, "b2"));
        Configuration config = new Configuration(bottles);

        FillMove move = new FillMove(bottles.get(0));
        move.apply(config);
        move.display();
        assertEquals(bottles.get(0).getWaterLevel(), 10);
        assertEquals(bottles.get(1).getWaterLevel(), 5);

        move.reverse(config);
        assertEquals(bottles.get(0).getWaterLevel(), 8);
        assertEquals(bottles.get(1).getWaterLevel(), 5);
    }
}