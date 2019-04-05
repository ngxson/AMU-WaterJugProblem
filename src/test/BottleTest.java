package test;

import com.ngxson.programmation.Bottle;
import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void pourAllTo() {
        Bottle bottle1 = new Bottle(10, 8, "b1");
        Bottle bottle2 = new Bottle(10, 5, "b2");

        bottle1.pourAllTo(bottle2);

        assertEquals(bottle1.getWaterLevel(), 3);
        assertEquals(bottle2.getWaterLevel(), 10);
    }

    @Test
    public void pourIn() {
        Bottle bottle = new Bottle(10, 8, "b1");
        int rest = bottle.pourIn(22);

        assertEquals(rest, 20);
    }
}