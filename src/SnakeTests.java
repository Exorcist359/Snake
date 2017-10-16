import levels.Level;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTests {

    @Test
    public void testPositionAfterMoving() throws Exception {
        Game game = new Game(new Level(4));
        SnakeDirection dir = SnakeDirection.Up;
        Point currentSnakePosition = new Point(game.getSnakeHead().column, game.getSnakeHead().row);
        //SnakeDirection currentSnakeDir = game.get

        //assertEquals(new Point(currentSnakePosition.X, currentSnakePosition.Y));

    }

}