package test;

import com.ngxson.programmation.Bottle;
import com.ngxson.programmation.Configuration;
import com.ngxson.programmation.move.Move;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationTest {

    @Test
    public void possibleMoves() {
        List<Bottle> bottles = new ArrayList<>();
        bottles.add(new Bottle(10, 8, "b1"));
        bottles.add(new Bottle(10, 5, "b2"));
        Configuration config = new Configuration(bottles);

        for (Move move : config.possibleMoves()) {
            move.apply();
            move.display();
            move.reverse();
        }
    }
}